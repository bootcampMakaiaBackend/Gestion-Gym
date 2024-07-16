package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Excepciones.EntrenadorExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServicio {

    private final EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    public EntrenadorServicio(EntrenadorRepositorio entrenadorRepositorio) {
        this.entrenadorRepositorio = entrenadorRepositorio;
    }

    public void crearEntrenador(Entrenador entrenador, Long id) {
        if (entrenadorRepositorio.existsById(id)) {
            throw new EntrenadorExistenteExcepcion(id);
        }
        if ((entrenador.getCertificaciones() == null) ||
                (entrenador.getEspecialidad() == null) ||
                (entrenador.getExperiencia() == null) ||
                (entrenador.getCorreoElectronico() == null) ||
                (entrenador.getContrasenia() == null) ||
                (entrenador.getNombreCompleto() == null)) {
            throw new InformacionIncompletaExcepcion();
        }
        entrenadorRepositorio.save(entrenador);
    }

    public void actualizarEntrenador(Long id, Entrenador entrenador) {
        Entrenador entrenadorActualizar = entrenadorRepositorio.findById(id).orElseThrow(() -> new EntrenadorNoEncontradoExcepcion(id));

        entrenadorActualizar.setNombreCompleto(entrenador.getNombreCompleto());
        entrenadorActualizar.setCorreoElectronico(entrenador.getCorreoElectronico());
        entrenadorActualizar.setEspecialidad(entrenador.getEspecialidad());
        entrenadorActualizar.setExperiencia(entrenador.getExperiencia());
        entrenadorActualizar.setCertificaciones(entrenador.getCertificaciones());

        entrenadorRepositorio.save(entrenadorActualizar);
    }

    public List<Entrenador> obtenerEntrenadores() {
        if (entrenadorRepositorio == null){
            throw new EntrenadorNoExistenteExcepcion();
        }
        return entrenadorRepositorio.findAll();
    }

    public Entrenador obtenerEntrenadorPorId(Long id) {
        return entrenadorRepositorio.findById(id).orElseThrow(() -> new EntrenadorNoEncontradoExcepcion(id));
    }

    public void eliminarEntrenador(Long id) {
        if (entrenadorRepositorio.existsById(id)) {
            entrenadorRepositorio.deleteById(id);
        } else {
            throw new EntrenadorNoEncontradoExcepcion(id);
        }
    }
}
