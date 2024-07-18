package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActividadServicio {

    @Autowired
    private RestTemplate restTemplate;

    private final String ACTIVIDAD_MICROSERVICE_URL = "http://localhost:8080/api/v1/actividades";

    public void asignarActividad(Long aprendizId, Long entrenadorId, String tipoEntrenamiento, int duracion) {
        String url = ACTIVIDAD_MICROSERVICE_URL + "/guardar";
        Map<String, Object> request = new HashMap<>();
        request.put("aprendizId", aprendizId);
        request.put("entrenadorId", entrenadorId);
        request.put("tipoEntrenamiento", tipoEntrenamiento);
        request.put("duracionEntrenamiento", duracion);

        restTemplate.postForObject(url, request, Void.class);
    }

    public List<ActividadEntrenamiento> obtenerReporteMensual(Long aprendizId) {
        String url = ACTIVIDAD_MICROSERVICE_URL + "/aprendiz/" + aprendizId;
        ResponseEntity<List<ActividadEntrenamiento>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ActividadEntrenamiento>>() {}
        );
        return response.getBody();
    }
}

