package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import com.gestion.GestionGym.Servicio.ActividadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actividades")
public class ActividadControlador {

    @Autowired
    private ActividadServicio actividadServicio;

    @PostMapping("/asignar")
    public ResponseEntity<Void> asignarActividad(@RequestParam Long aprendizId, @RequestParam Long entrenadorId, @RequestParam String tipoEntrenamiento, @RequestParam int duracion) {
        actividadServicio.asignarActividad(aprendizId, entrenadorId, tipoEntrenamiento, duracion);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reporte/{aprendizId}")
    public ResponseEntity<List<ActividadEntrenamiento>> obtenerReporteMensual(@PathVariable Long aprendizId) {
        List<ActividadEntrenamiento> reporte = actividadServicio.obtenerReporteMensual(aprendizId);
        return ResponseEntity.ok(reporte);
    }
}
