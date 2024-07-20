package com.gestion.GestionGym.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ActividadesServicio {
    @Autowired
    private RestTemplate restTemplate;

    public List<Object> obtenerReporteMensual(String aprendizId) {
        String url = "http://localhost:8081/api/actividades/reportes/aprendiz/" + aprendizId;
        ResponseEntity<List<Object>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Object>>() {
                });
        return response.getBody();
    }
}
