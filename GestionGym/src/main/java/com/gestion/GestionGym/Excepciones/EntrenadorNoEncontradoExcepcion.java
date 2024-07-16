package com.gestion.GestionGym.Excepciones;

public class EntrenadorNoEncontradoExcepcion extends RuntimeException{
    public EntrenadorNoEncontradoExcepcion(Long id) {
        super("Entrenador con id " + id + " no encontrado");
    }
}
