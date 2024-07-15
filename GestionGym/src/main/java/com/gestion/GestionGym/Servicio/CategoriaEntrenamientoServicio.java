package com.gestion.GestionGym.Servicio;


import com.gestion.GestionGym.Excepciones.CategoriaNoEncontradaExcepcion;
import com.gestion.GestionGym.Modelo.CategoriaEntrenamiento;
import com.gestion.GestionGym.Repositorio.CategoriaEntrenamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaEntrenamientoServicio {

    @Autowired
    private CategoriaEntrenamientoRepositorio CategoriaEntrenamientoRepositorio;

    public CategoriaEntrenamiento agregarCategoriaEntrenamiento(CategoriaEntrenamiento categoriaEntrenamiento) {
        return CategoriaEntrenamientoRepositorio.save(categoriaEntrenamiento);
    }

    public CategoriaEntrenamiento modificarCategoriaEntrenamiento(Long id, CategoriaEntrenamiento categoria) {
        CategoriaEntrenamiento existente = CategoriaEntrenamientoRepositorio.findById(id).orElseThrow(() -> new CategoriaNoEncontradaExcepcion(id));
        existente.setNombre(categoria.getNombre());
        return CategoriaEntrenamientoRepositorio.save(existente);
    }

    public CategoriaEntrenamiento obtenerCategoriaEntrenamiento(Long id) {
        return CategoriaEntrenamientoRepositorio.findById(id).orElseThrow(() -> new CategoriaNoEncontradaExcepcion(id));
    }

    public List<CategoriaEntrenamiento> obtenerTodasCategoriasEntrenamiento() {
        return CategoriaEntrenamientoRepositorio.findAll();
    }
}
