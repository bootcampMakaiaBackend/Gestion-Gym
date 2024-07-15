package com.gestion.GestionGym.Excepciones;

public class CategoriaNoEncontradaExcepcion extends RuntimeException{
    public CategoriaNoEncontradaExcepcion(long id) {
        super("Categoria " + id + " no encontrada");
    }
}
