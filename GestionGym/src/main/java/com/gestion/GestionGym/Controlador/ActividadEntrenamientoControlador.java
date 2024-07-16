package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Excepciones.ActividadExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import com.gestion.GestionGym.Servicio.ActividadEntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actividad_entrenamiento")
public class ActividadEntrenamientoControlador {

    private final ActividadEntrenamientoService actividadEntrenamientoService;

    @Autowired
    public ActividadEntrenamientoControlador(ActividadEntrenamientoService actividadEntrenamientoService) {
        this.actividadEntrenamientoService = actividadEntrenamientoService;
    }

    @PostMapping
    public ResponseEntity<String> crearActividad(@RequestBody ActividadEntrenamiento actividadEntrenamiento) {
        try {
            this.actividadEntrenamientoService.crearActividad(actividadEntrenamiento);
            return ResponseEntity.ok("Se creo la actividad correctamente");
        } catch (ActividadExistenteExcepcion | InformacionIncompletaExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<ActividadEntrenamiento> obtenerActividades() {
        return this.actividadEntrenamientoService.obtenerActividades();
    }

    @GetMapping("/{aprendiz_id}/reporte/{mes}/{anio}")
    public String obtenerReporteMensual(@PathVariable("aprendiz_id") Long aprendiz_id, @PathVariable("mes") int mes, @PathVariable("anio") int anio) {
        return actividadEntrenamientoService.obtenerReporteMensual(aprendiz_id, mes, anio);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarActividad(@PathVariable Long id) {
        this.actividadEntrenamientoService.eliminarActividad(id);
        return ResponseEntity.ok("Se elimino la actividad correctamente");
    }
}
