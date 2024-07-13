package com.gestion.GestionGym.Repositorio;

import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActividadEntrenamientoRepositorio extends JpaRepository<ActividadEntrenamiento, Long> {
    @Query("SELECT a FROM ActividadEntrenamiento a WHERE a.aprendiz.id = :aprendizId AND MONTH(a.fechaEntrenamiento) = :mes AND YEAR(a.fechaEntrenamiento) = :anio")
    List<ActividadEntrenamiento> findByAprendizIdAndMesAndAnio(@Param("aprendizId") Long aprendizId, @Param("mes") int mes, @Param("anio") int anio);
}