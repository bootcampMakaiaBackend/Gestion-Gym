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

    private AprendizServicio aprendizServicio;

    @Autowired
    public AprendizControlador(AprendizServicio aprendizServicio) {
        this.aprendizServicio = aprendizServicio;
    }

    @PostMapping
    public ResponseEntity<String> crearAprendiz(@RequestBody Aprendiz aprendiz){
        this.aprendizServicio.crearAprendiz(aprendiz);
        return ResponseEntity.ok("Se creo el aprendiz correctamente");
    }

    @GetMapping
    public List<Aprendiz> obtenerAprendices(){
        return this.aprendizServicio.obtenerAprendices();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAprendiz(@PathVariable Long id){
        this.aprendizServicio.eliminarAprendiz(id);
        return ResponseEntity.ok("Se elimino el aprendiz correctamente");
    }
}
