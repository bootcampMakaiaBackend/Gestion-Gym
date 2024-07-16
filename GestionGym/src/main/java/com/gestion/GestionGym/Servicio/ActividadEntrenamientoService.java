package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Excepciones.ActividadExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import com.gestion.GestionGym.Repositorio.ActividadEntrenamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActividadEntrenamientoService {

    private final ActividadEntrenamientoRepositorio actividadEntrenamientoRepositorio;

    @Autowired
    public ActividadEntrenamientoService(ActividadEntrenamientoRepositorio actividadEntrenamientoRepositorio) {
        this.actividadEntrenamientoRepositorio = actividadEntrenamientoRepositorio;
    }

    public void crearActividad(ActividadEntrenamiento actividadEntrenamiento) {
        if (actividadEntrenamientoRepositorio.existsByFechaEntrenamientoAndTipoEntrenamiento(actividadEntrenamiento.getFechaEntrenamiento(), actividadEntrenamiento.getTipoEntrenamiento())) {
            throw new ActividadExistenteExcepcion(actividadEntrenamiento.getFechaEntrenamiento(), actividadEntrenamiento.getTipoEntrenamiento());
        }

        if (actividadEntrenamiento.getFechaEntrenamiento() == null ||
                actividadEntrenamiento.getTipoEntrenamiento() == null ||
                actividadEntrenamiento.getAprendiz() == null) {
            throw new InformacionIncompletaExcepcion();
        }
        actividadEntrenamientoRepositorio.save(actividadEntrenamiento);
    }

    public List<ActividadEntrenamiento> obtenerActividades() {
        return actividadEntrenamientoRepositorio.findAll();
    }

    private int obtenerNumeroSemana(LocalDate fecha, int anio) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return fecha.get(weekFields.weekOfMonth());
    }

    private String obtenerNombreMes(int mes) {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "Mes fuera de rango";
        }
    }

    //Obtener reportes mensual de un aprendiz
    // TODO: este se debe comunicar con el segundo microservicio para obtener esta informacion.
    public String obtenerReporteMensual(Long aprendiz_id, int mes, int anio) {
        List<ActividadEntrenamiento> actividadEntrenamientos = actividadEntrenamientoRepositorio.findByAprendizIdAndMesAndAnio(aprendiz_id, mes, anio);

        Map<Integer, List<ActividadEntrenamiento>> actividadPorSemana = actividadEntrenamientos.stream().
                collect(Collectors.groupingBy(a -> obtenerNumeroSemana(a.getFechaEntrenamiento(), anio)));
        StringBuilder reporte = new StringBuilder();
        reporte.append(String.format("Reporte mensual del aprendiz %d (%s %d):%n%n", aprendiz_id, obtenerNombreMes(mes), anio));

        actividadPorSemana.forEach((semana, actividadesDeLaSemana) -> {
            reporte.append(String.format("Semana %d:%n", semana));
            actividadesDeLaSemana.forEach(a -> {
                reporte.append(String.format("- %s: %s, %s%n", a.getFechaEntrenamiento().getDayOfWeek().name(),
                        a.getFechaEntrenamiento(),
                        a.getTipoEntrenamiento()));
            });
        });
        return reporte.toString();
    }

    public void eliminarActividad(Long id) {
        actividadEntrenamientoRepositorio.deleteById(id);
    }
}
