package com.gestion.GestionGym.Repositorio;

import com.gestion.GestionGym.Modelo.ActividadEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadEntrenamientoRepositorio extends JpaRepository<ActividadEntrenamiento, Long> {
}
