package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Excepciones.CategoriaExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.CategoriaEntrenamiento;
import com.gestion.GestionGym.Servicio.CategoriaEntrenamientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categoria_entrenamiento")
public class CategoriaEntrenamientoControlador {

    private final CategoriaEntrenamientoServicio categoriaEntrenamientoServicio;

    @Autowired
    public CategoriaEntrenamientoControlador(CategoriaEntrenamientoServicio categoriaEntrenamientoServicio, CategoriaEntrenamientoServicio categoriaEntrenamientoServicio1) {
        this.categoriaEntrenamientoServicio = categoriaEntrenamientoServicio1;
    }

    @PostMapping
    public ResponseEntity<String> agregarCategoriaEntrenamiento(@RequestBody CategoriaEntrenamiento categoriaEntrenamiento) {
        try {
            this.categoriaEntrenamientoServicio.agregarCategoriaEntrenamiento(categoriaEntrenamiento);
            return ResponseEntity.ok("Se creó la categoría de entrenamiento correctamente");
        } catch (CategoriaExistenteExcepcion | InformacionIncompletaExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/modificar")
    public ResponseEntity<String> modificarCategoriaEntrenamiento(@PathVariable Long id, @RequestBody CategoriaEntrenamiento categoriaEntrenamiento) {
        categoriaEntrenamientoServicio.modificarCategoriaEntrenamiento(id, categoriaEntrenamiento);
        return ResponseEntity.ok("Se modificó la categoría de entrenamiento correctamente");
    }

    @GetMapping("/{id}")
    public CategoriaEntrenamiento obtenerCategoriaEntrenamientoPorId(@PathVariable Long id) {
        return categoriaEntrenamientoServicio.obtenerCategoriaEntrenamientoPorId(id);
    }

    @GetMapping
    public List<CategoriaEntrenamiento> obtenerCategoriasDeEntrenamientos() {
        return categoriaEntrenamientoServicio.obtenerCategoriasDeEntrenamientos();
    }

}
