package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Servicio.EntrenadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/entrenador")
public class EntrenadorControlador {

    private EntrenadorServicio entrenadorServicio;

    @Autowired
    public EntrenadorControlador(EntrenadorServicio entrenadorServicio) {
        this.entrenadorServicio = entrenadorServicio;
    }

    @PostMapping
    public ResponseEntity<String> crearEntrenador(@RequestBody Entrenador entrenador){
        this.entrenadorServicio.crearEntrenador(entrenador);
        return ResponseEntity.ok("Se creo el entrenador correctamente");
    }

    @GetMapping
    public List<Entrenador> obtenerEntrenadores(){
        return this.entrenadorServicio.obtenerEntrenadores();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEntrenador(@PathVariable Long id){
        this.entrenadorServicio.eliminarEntrenador(id);
        return ResponseEntity.ok("Se elimino el entrenador correctamente");
    }
}
