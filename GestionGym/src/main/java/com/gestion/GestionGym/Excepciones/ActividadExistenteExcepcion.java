package com.gestion.GestionGym.Excepciones;

import java.time.LocalDate;

public class ActividadExistenteExcepcion extends RuntimeException{
    public ActividadExistenteExcepcion(LocalDate fecha, String tipoEntrenamiento) {
        super("La actividad de entrenamiento con fecha " + fecha + " y " + tipoEntrenamiento + " ya existe.");
    }
}
