package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Excepciones.EntrenadorExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Servicio.EntrenadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/entrenador")
public class EntrenadorControlador {

    private final EntrenadorServicio entrenadorServicio;

    @Autowired
    public EntrenadorControlador(EntrenadorServicio entrenadorServicio) {
        this.entrenadorServicio = entrenadorServicio;
    }

    @PostMapping
    public ResponseEntity<String> crearEntrenador(@RequestBody Entrenador entrenador, Long id) {
        try {
            this.entrenadorServicio.crearEntrenador(entrenador, id);
            return ResponseEntity.ok("Se creó el entrenador correctamente");
        }catch (EntrenadorExistenteExcepcion | InformacionIncompletaExcepcion e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEntrenador(@PathVariable("id") Long id, @RequestBody Entrenador entrenador) {
        try {
            this.entrenadorServicio.actualizarEntrenador(id, entrenador);
            return ResponseEntity.ok("Se actualizó el entrenador correctamente");
        }catch (EntrenadorNoEncontradoExcepcion e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Entrenador>> obtenerEntrenadores() {
        try {
            List<Entrenador> entrenadores = this.entrenadorServicio.obtenerEntrenadores();
            return ResponseEntity.ok(entrenadores);
        } catch (EntrenadorNoExistenteExcepcion e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtenerEntrenadorPorId(@PathVariable("id") Long id) {
        try {
            Entrenador entrenador = entrenadorServicio.obtenerEntrenadorPorId(id);
            return ResponseEntity.ok(entrenador);
        }catch (EntrenadorNoEncontradoExcepcion e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEntrenador(@PathVariable Long id) {
        try {
            this.entrenadorServicio.eliminarEntrenador(id);
            return ResponseEntity.ok("Se eliminó el entrenador correctamente");
        }catch (EntrenadorNoExistenteExcepcion e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
