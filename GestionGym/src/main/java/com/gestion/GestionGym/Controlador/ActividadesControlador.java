package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Servicio.ActividadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadesControlador {

    @Autowired
    private ActividadesServicio actividadesServicio;

    @GetMapping("/reportes/aprendiz/{id}")
    public List<Object> obtenerReporteMensual(@PathVariable String id) {
        return actividadesServicio.obtenerReporteMensual(id);
    }
}
