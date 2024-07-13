package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Servicio.AprendizServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aprendiz")
public class AprendizControlador {

    private final AprendizServicio aprendizServicio;

    @Autowired
    public AprendizControlador(AprendizServicio aprendizServicio) {
        this.aprendizServicio = aprendizServicio;
    }

    @PostMapping
    public ResponseEntity<String> crearAprendiz(@RequestBody Aprendiz aprendiz) {
        this.aprendizServicio.crearAprendiz(aprendiz);
        return ResponseEntity.ok("Se creo el aprendiz correctamente");
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<String> actualizarAprendiz(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
        aprendizServicio.actualizarAprendiz(id, aprendiz);
        return ResponseEntity.ok("Se actualizó el aprendiz correctamente");
    }

    @GetMapping
    public List<Aprendiz> obtenerAprendices() {
        return this.aprendizServicio.obtenerAprendices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aprendiz> obtenerAprendizPorId(@PathVariable Long id) {
        Aprendiz aprendiz = this.aprendizServicio.obtenerAprendizPorId(id);
        return ResponseEntity.ok(aprendiz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAprendiz(@PathVariable Long id) {
        this.aprendizServicio.eliminarAprendiz(id);
        return ResponseEntity.ok("Se elimino el aprendiz correctamente");
    }
}
