package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Servicio.ActividadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actividades")
public class ActividadesControlador {

    @Autowired
    private ActividadesServicio actividadesServicio;

    //http://localhost:8080/api/actividades/reportes/aprendiz/1?mes=4&anio=2024
    @GetMapping("/reportes/aprendiz/{id}")
    public ResponseEntity<String> obtenerReporteMensual(@PathVariable Long id, @RequestParam int mes, @RequestParam int anio) {
        try {
            String reporte = actividadesServicio.obtenerReporteMensual(id, mes, anio);
            return ResponseEntity.ok(reporte);
        } catch (Exception e ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ingrese el usuario y contraseña.");
        }
    }
}
