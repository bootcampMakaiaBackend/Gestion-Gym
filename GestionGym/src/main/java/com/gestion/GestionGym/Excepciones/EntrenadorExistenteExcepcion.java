package com.gestion.GestionGym.Excepciones;

public class EntrenadorExistenteExcepcion extends RuntimeException{

    public EntrenadorExistenteExcepcion(Long id) {
        super("El entrenador con id " + id + " ya existe");
    }
}
