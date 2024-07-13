package com.gestion.GestionGym.Servicio;

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

    public void crearEntrenador(Entrenador entrenador) {
        entrenadorRepositorio.save(entrenador);
    }

    public void actualizarEntrenador(Long id, Entrenador entrenador) {
        Entrenador entrenadorActualizar = entrenadorRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        entrenadorActualizar.setNombreCompleto(entrenador.getNombreCompleto());
        entrenadorActualizar.setCorreoElectronico(entrenador.getCorreoElectronico());
        entrenadorActualizar.setEspecialidad(entrenador.getEspecialidad());
        entrenadorActualizar.setExperiencia(entrenador.getExperiencia());
        entrenadorActualizar.setCertificaciones(entrenador.getCertificaciones());

        entrenadorRepositorio.save(entrenadorActualizar);
    }

    public List<Entrenador> obtenerEntrenadores() {
        return entrenadorRepositorio.findAll();
    }

    public Entrenador obtenerEntrenadorPorId(Long id) {
        return entrenadorRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Entrenador con id " + id + " no encontrado"));
    }

    public void eliminarEntrenador(Long id) {
        if (entrenadorRepositorio.existsById(id)) {
            entrenadorRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Entrenador con id" + id + "no encontrado");
        }
    }
}
