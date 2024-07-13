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

    //Obtener reportes mensual de un aprendiz
    // TODO: este se debe comunicar con el segundo microservicio para obtener esta informacion.
    public List<ActividadEntrenamiento> obtenerReporteMensual(Long aprendiz_id, int mes, int anio) {
        return actividadEntrenamientoRepositorio.findByAprendizIdAndMesAndAnio(aprendiz_id, mes, anio);
    }

    public void eliminarActividad(Long id) {
        actividadEntrenamientoRepositorio.deleteById(id);
    }
}
