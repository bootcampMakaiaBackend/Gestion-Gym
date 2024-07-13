package com.gestion.GestionGym.Repositorio;

import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActividadEntrenamientoRepositorio extends JpaRepository<ActividadEntrenamiento, Long> {
    List<ActividadEntrenamiento> findByAprendizIdAndMesAndAnio(Long aprendizId, int mes, int anio);
}
