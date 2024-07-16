package com.gestion.GestionGym.Servicio;


import com.gestion.GestionGym.Excepciones.CategoriaExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.CategoriaNoEncontradaExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.CategoriaEntrenamiento;
import com.gestion.GestionGym.Repositorio.CategoriaEntrenamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaEntrenamientoServicio {

    private final CategoriaEntrenamientoRepositorio categoriaEntrenamientoRepositorio;

    @Autowired
    public CategoriaEntrenamientoServicio(CategoriaEntrenamientoRepositorio categoriaEntrenamientoRepositorio) {
        this.categoriaEntrenamientoRepositorio = categoriaEntrenamientoRepositorio;
    }

    public void agregarCategoriaEntrenamiento(CategoriaEntrenamiento categoriaEntrenamiento) {
        if (categoriaEntrenamientoRepositorio.existsByNombre(categoriaEntrenamiento.getNombre())) {
            throw new CategoriaExistenteExcepcion(categoriaEntrenamiento.getNombre());
        }
        if (categoriaEntrenamiento.getNombre() == null) {
            throw new InformacionIncompletaExcepcion();
        }
        categoriaEntrenamientoRepositorio.save(categoriaEntrenamiento);
    }

    public void modificarCategoriaEntrenamiento(Long id, CategoriaEntrenamiento categoria) {
        CategoriaEntrenamiento existente = categoriaEntrenamientoRepositorio.findById(id).orElseThrow(() -> new CategoriaNoEncontradaExcepcion(id));
        existente.setNombre(categoria.getNombre());
        categoriaEntrenamientoRepositorio.save(existente);
    }

    public CategoriaEntrenamiento obtenerCategoriaEntrenamientoPorId(Long id) {
        return categoriaEntrenamientoRepositorio.findById(id).orElseThrow(() -> new CategoriaNoEncontradaExcepcion(id));
    }

    public List<CategoriaEntrenamiento> obtenerCategoriasDeEntrenamientos() {
        return categoriaEntrenamientoRepositorio.findAll();
    }
}
