package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Modelo.CategoriaEntrenamiento;
import com.gestion.GestionGym.Servicio.ActividadEntrenamientoService;
import com.gestion.GestionGym.Servicio.AprendizServicio;
import com.gestion.GestionGym.Servicio.CategoriaEntrenamientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/CategoriaEntrenamiento")
public class CategoriaEntrenamientoControlador {

    private final CategoriaEntrenamientoServicio categoriaEntrenamientoServicio;
    @Autowired
    public CategoriaEntrenamientoControlador(CategoriaEntrenamientoServicio categoriaEntrenamientoServicio, CategoriaEntrenamientoServicio categoriaEntrenamientoServicio1) {
        this.categoriaEntrenamientoServicio = categoriaEntrenamientoServicio1;
    }


    @PostMapping
    public ResponseEntity<String> agregarCategoriaEntrenamiento(@RequestBody CategoriaEntrenamiento categoriaEntrenamiento) {
        this.categoriaEntrenamientoServicio.agregarCategoriaEntrenamiento(categoriaEntrenamiento);
        return ResponseEntity.ok("Se creo la categoria de entrenamiento correctamente");
    }

    @PutMapping("/{id}/modificar")
    public ResponseEntity<String> modificarCategoriaEntrenamiento(@PathVariable Long id, @RequestBody CategoriaEntrenamiento categoriaEntrenamiento) {
        categoriaEntrenamientoServicio.modificarCategoriaEntrenamiento(id, categoriaEntrenamiento);
        return ResponseEntity.ok("Se modifico la categoria de entrenamiento correctamente");
    }

    @GetMapping("/{id}")
    public CategoriaEntrenamiento obtenerCategoriaEntrenamiento(@PathVariable Long id) {
        return categoriaEntrenamientoServicio.obtenerCategoriaEntrenamiento(id);
    }

    @GetMapping
    public List<CategoriaEntrenamiento> obtenerTodasCategoriasEntrenamiento() {
        return categoriaEntrenamientoServicio.obtenerTodasCategoriasEntrenamiento();
    }

}
