package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import com.gestion.GestionGym.Repositorio.ActividadEntrenamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadEntrenamientoService {

    private final ActividadEntrenamientoRepositorio actividadEntrenamientoRepositorio;

    @Autowired
    public ActividadEntrenamientoService(ActividadEntrenamientoRepositorio actividadEntrenamientoRepositorio) {
        this.actividadEntrenamientoRepositorio = actividadEntrenamientoRepositorio;
    }

    public void crearActividad(ActividadEntrenamiento actividadEntrenamiento) {
        actividadEntrenamientoRepositorio.save(actividadEntrenamiento);
    }

    public List<ActividadEntrenamiento> obtenerActividades() {
        return actividadEntrenamientoRepositorio.findAll();
    }

  private String obtenerNombreMes(int mes){
        switch (mes){
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "Mes desconocido";
        }
  }
    //Obtener reportes mensual de un aprendiz
    // TODO: este se debe comunicar con el segundo microservicio para obtener esta informacion.
    public List<ActividadEntrenamiento> obtenerReporteMensual(Long aprendiz_id, int mes, int anio) {
        return actividadEntrenamientoRepositorio.findByAprendizIdAndMesAndAnio(aprendiz_id, mes, anio);
    }

    public void eliminarActividad(Long id) {
        actividadEntrenamientoRepositorio.deleteById(id);
    }
}
