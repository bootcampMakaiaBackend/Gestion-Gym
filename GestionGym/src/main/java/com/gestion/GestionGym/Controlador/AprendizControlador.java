package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Excepciones.AprendizExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.AprendizNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Servicio.AprendizServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> crearAprendiz(@RequestBody Aprendiz aprendiz, Long id) {
        try {
            this.aprendizServicio.crearAprendiz(aprendiz, id);
            return ResponseEntity.ok("Se creo el aprendiz correctamente");
        }catch (AprendizExistenteExcepcion | InformacionIncompletaExcepcion e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<String> actualizarAprendiz(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
        try {
            aprendizServicio.actualizarAprendiz(id, aprendiz);
            return ResponseEntity.ok("Se actualizó el aprendiz correctamente");
        }catch (AprendizNoEncontradoExcepcion e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
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
