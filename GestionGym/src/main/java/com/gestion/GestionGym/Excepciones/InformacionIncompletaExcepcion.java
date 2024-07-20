package com.gestion.GestionGym.Excepciones;

public class InformacionIncompletaExcepcion extends RuntimeException{

    public InformacionIncompletaExcepcion() {
        super("Información incompleta. Por favor, revise los campos obligatorios.");
    }
}