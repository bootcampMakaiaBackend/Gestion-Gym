package com.gestion.GestionGym;


import com.gestion.GestionGym.Excepciones.EntrenadorNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import com.gestion.GestionGym.Servicio.EntrenadorServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EntrenadorServicioTest {


    private EntrenadorRepositorio entrenadorRepositorio;
    private EntrenadorServicio entrenadorServicio;

    @BeforeEach
    public void setUp() {

        this.entrenadorRepositorio = mock(EntrenadorRepositorio.class);
        this.entrenadorServicio = new EntrenadorServicio(entrenadorRepositorio);
    }

    @Test
    public void CrearEntrenadorIncompleto() {

        Entrenador entrenador1 = new Entrenador();
        entrenador1.setId(1L);
        entrenador1.setCorreoElectronico("omar@gmail.com");

        assertThrows(InformacionIncompletaExcepcion.class, () -> entrenadorServicio.crearEntrenador(entrenador1));
        verify(entrenadorRepositorio, times(1));
    }


    @Test
    public void ActualizarEntrenador() {

        //Arrange

        Long id = 1L;

        Entrenador entrenador1 = new Entrenador();

        entrenador1.setId(id);
        entrenador1.setNombreCompleto("Omar Bonett");

        Entrenador actualizar = new Entrenador();

        actualizar.setNombreCompleto("luis Bautista");

        when(entrenadorRepositorio.findById(id)).thenReturn(Optional.of(entrenador1));
        when(entrenadorRepositorio.save(any(Entrenador.class))).thenReturn(entrenador1);

        //act
        Entrenador resultado = entrenadorServicio.actualizarEntrenador(id, actualizar);

        //Assert
        assertEquals("luis Bautista", resultado.getNombreCompleto());
        verify(entrenadorRepositorio, times(1)).save(entrenador1);

    }


    @Test
    public void obtenerEntrenadores() {
        // Arrange
        Entrenador entrenador1 = new Entrenador();
        entrenador1.setId(1L);
        entrenador1.setCorreoElectronico("omar@gmail.com");
        Entrenador entrenador2 = new Entrenador();
        entrenador2.setId(2L);
        entrenador2.setCorreoElectronico("luis@gmail.com");

        List<Entrenador> entrenador = new ArrayList<>();
        entrenador.add(entrenador1);
        entrenador.add(entrenador2);

        when(entrenadorRepositorio.findAll()).thenReturn(entrenador);

        // Act
        List<Entrenador> resultado = entrenadorServicio.obtenerEntrenadores();

        // Assert
        assertEquals(2, resultado.size(), "El tamaño de la lista debería ser 2");
        assertEquals("omar@gmail.com", resultado.get(0).getCorreoElectronico(), "El primer correo entrenador debería ser omar");
        assertEquals("luis@gmail.com", resultado.get(1).getCorreoElectronico(), "El segundo correo entrenador debería ser luis");
    }

    @Test
    public void obtenerEntrenadorPorIdNoExistente() {
        //Arrange
        Long id = 1L;
        when(entrenadorRepositorio.findById(id)).thenReturn(Optional.empty());

        //Act-Assert
        assertThrows(EntrenadorNoEncontradoExcepcion.class, () -> entrenadorServicio.obtenerEntrenadorPorId(id));
        verify(entrenadorRepositorio, times(1)).findById(id);
    }

    @Test
    public void eliminarEntrenador() {
        //Arrange
        Long id = 1L;
        Entrenador entrenador = new Entrenador();
        entrenador.setId(id);
        when(entrenadorRepositorio.existsById(id)).thenReturn(true);

        //Act
        entrenadorServicio.eliminarEntrenador(id);

        //Assert
        verify(entrenadorRepositorio, times(1)).deleteById(id);
    }

}