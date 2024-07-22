package com.gestion.GestionGym;

import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Repositorio.AprendizRepositorio;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import com.gestion.GestionGym.Servicio.AprendizServicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AprendizServicioTest {

    private EntrenadorRepositorio entrenadorRepositorio;
    private AprendizRepositorio aprendizRepositorio;
    private AprendizServicio aprendizServicio;

    @BeforeEach
    public void setUp() {

        this.aprendizRepositorio = mock(AprendizRepositorio.class);
        this.aprendizServicio = new AprendizServicio(aprendizRepositorio, entrenadorRepositorio);

    }



}