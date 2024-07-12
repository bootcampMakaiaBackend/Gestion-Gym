package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServicio {

    private EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    public EntrenadorServicio(EntrenadorRepositorio entrenadorRepositorio) {
        this.entrenadorRepositorio = entrenadorRepositorio;
    }

    public void crearEntrenador(Entrenador entrenador){
        entrenadorRepositorio.save(entrenador);
    }

    public List<Entrenador> obtenerEntrenadores(){
        return entrenadorRepositorio.findAll();
    }

    public void eliminarEntrenador(Long id){
        entrenadorRepositorio.deleteById(id);
    }
}
