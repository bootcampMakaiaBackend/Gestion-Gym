package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import com.gestion.GestionGym.Repositorio.ActividadEntrenamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadEntrenamientoService {

    private ActividadEntrenamientoRepositorio actividadEntrenamientoRepositorio;

    @Autowired
    public ActividadEntrenamientoService(ActividadEntrenamientoRepositorio actividadEntrenamientoRepositorio) {
        this.actividadEntrenamientoRepositorio = actividadEntrenamientoRepositorio;
    }

    public void crearActividad(ActividadEntrenamiento actividadEntrenamiento){
        actividadEntrenamientoRepositorio.save(actividadEntrenamiento);
    }

    public List<ActividadEntrenamiento> obtenerActividad(){
        return actividadEntrenamientoRepositorio.findAll();
    }

    public void eliminarActividad(Long id){
        actividadEntrenamientoRepositorio.deleteById(id);
    }
}
