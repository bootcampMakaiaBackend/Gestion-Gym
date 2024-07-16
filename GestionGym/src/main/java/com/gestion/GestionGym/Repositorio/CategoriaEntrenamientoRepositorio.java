package com.gestion.GestionGym.Repositorio;

import com.gestion.GestionGym.Modelo.CategoriaEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaEntrenamientoRepositorio extends JpaRepository<CategoriaEntrenamiento, Long> {
    boolean existsByNombre(String nombreCategoria);
}
