package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Excepciones.AprendizExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.AprendizNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Repositorio.AprendizRepositorio;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AprendizServicio {

    private final AprendizRepositorio aprendizRepositorio;
    private final EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    public AprendizServicio(EntrenadorRepositorio entrenadorRepositorio, AprendizRepositorio aprendizRepositorio) {
        this.entrenadorRepositorio = entrenadorRepositorio;
        this.aprendizRepositorio = aprendizRepositorio;
    }

    public void crearAprendiz(Aprendiz aprendiz, Long entrenadorId) {
        Optional<Entrenador> entrenador = entrenadorRepositorio.findById(entrenadorId);
        if (entrenador.isEmpty()) {
            throw new EntrenadorNoEncontradoExcepcion(entrenadorId);
        }

        if (aprendizRepositorio.existsByCorreoElectronico(aprendiz.getCorreoElectronico())) {
            throw new AprendizExistenteExcepcion(aprendiz.getCorreoElectronico());
        }
        if ((aprendiz.getNombreCompleto() == null) ||
                (aprendiz.getContrasenia() == null) ||
                (aprendiz.getCorreoElectronico() == null) ||
                (aprendiz.getFechaNacimiento() == null) ||
                (aprendiz.getGenero() == null) ||
                (aprendiz.getObjetivo() == null) ||
                (aprendiz.getNivelCondicion() == null)) {
            throw new InformacionIncompletaExcepcion();
        }

        aprendiz.setEntrenador(entrenador.get());
        aprendizRepositorio.save(aprendiz);
    }

    public void actualizarAprendiz(Long id, Aprendiz aprendiz) {
        Aprendiz aprendizActualizar = aprendizRepositorio.findById(id).orElseThrow(() -> new AprendizNoEncontradoExcepcion(id));

        aprendizActualizar.setNombreCompleto(aprendiz.getNombreCompleto());
        aprendizActualizar.setCorreoElectronico(aprendiz.getCorreoElectronico());
        aprendizActualizar.setContrasenia(aprendiz.getContrasenia());
        aprendizActualizar.setGenero(aprendiz.getGenero());
        aprendizActualizar.setObjetivo(aprendiz.getObjetivo());
        aprendizActualizar.setNivelCondicion(aprendiz.getNivelCondicion());
        aprendizActualizar.setEntrenador(aprendiz.getEntrenador());

        aprendizRepositorio.save(aprendizActualizar);
    }

    public List<Aprendiz> obtenerAprendices() {
        return aprendizRepositorio.findAll();
    }

    public Aprendiz obtenerAprendizPorId(Long id) {
        return aprendizRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Aprendiz con id " + id + " no encontrado"));
    }

    public void eliminarAprendiz(Long id) {
        aprendizRepositorio.deleteById(id);
    }
}
