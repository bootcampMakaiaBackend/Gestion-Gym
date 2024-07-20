package com.gestion.GestionGym.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ActividadesServicio {
    @Autowired
    private RestTemplate restTemplate;

    public List<Object> obtenerReporteMensual(String aprendizId) {
        String url = "http://localhost:8081/api/reportes/aprendiz/" + aprendizId;
        return restTemplate.getForObject(url, List.class);
    }
}
