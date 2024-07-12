package com.gestion.GestionGym.Modelo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrenador_id")
    private Long id;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "esperiencia")
    private String experiencia;

    @Column(name = "certificaciones")
    private Set<String> certificaciones;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    private List<Aprendiz> aprendices;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    private List<ActividadEntrenamiento> actividadEntrenamientos;

    public Entrenador() {
    }

    public Entrenador(List<ActividadEntrenamiento> actividadEntrenamientos, List<Aprendiz> aprendices, Set<String> certificaciones, String contraseña, String correo, String especialidad, String experiencia, Long id, String nombreCompleto) {
        this.actividadEntrenamientos = actividadEntrenamientos;
        this.aprendices = aprendices;
        this.certificaciones = certificaciones;
        this.contraseña = contraseña;
        this.correo = correo;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    public List<Aprendiz> getAprendices() {
        return aprendices;
    }

    public void setAprendices(List<Aprendiz> aprendices) {
        this.aprendices = aprendices;
    }

    public Set<String> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(Set<String> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<ActividadEntrenamiento> getActividadEntrenamientos() {
        return actividadEntrenamientos;
    }

    public void setActividadEntrenamientos(List<ActividadEntrenamiento> actividadEntrenamientos) {
        this.actividadEntrenamientos = actividadEntrenamientos;
    }
}
