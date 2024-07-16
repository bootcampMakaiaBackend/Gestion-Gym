package com.gestion.GestionGym.Excepciones;

public class AprendizExistenteExcepcion extends RuntimeException{

    public AprendizExistenteExcepcion(Long id) {
        super("El aprendiz con id " + id + " ya existe");
    }
}
