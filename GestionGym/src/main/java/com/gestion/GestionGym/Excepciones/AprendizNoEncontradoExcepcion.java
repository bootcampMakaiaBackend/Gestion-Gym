package com.gestion.GestionGym.Excepciones;

public class AprendizNoEncontradoExcepcion extends RuntimeException {
    public AprendizNoEncontradoExcepcion(Long id) {
        super("Aprendiz con id " + id + " no encontrado");
    }
}
