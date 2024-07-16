package com.gestion.GestionGym.Excepciones;

public class CategoriaExistenteExcepcion extends RuntimeException {
    public CategoriaExistenteExcepcion(String nombreCategoria) {
        super("La categoria " + nombreCategoria + " ya existe");
    }
}
