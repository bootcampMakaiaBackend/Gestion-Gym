package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Repositorio.AprendizRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprendizServicio {

    private final AprendizRepositorio aprendizRepositorio;

    @Autowired
    public AprendizServicio(AprendizRepositorio aprendizRepositorio) {
        this.aprendizRepositorio = aprendizRepositorio;
    }

    public void crearAprendiz(Aprendiz aprendiz){
        aprendizRepositorio.save(aprendiz);
    }

    public List<Aprendiz> obtenerAprendices(){
        return aprendizRepositorio.findAll();
    }

    public void eliminarAprendiz(Long id){
        aprendizRepositorio.deleteById(id);
    }

}
