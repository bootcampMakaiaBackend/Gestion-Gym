package com.gestion.GestionGym.Modelo;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "aprendriz")
public class Aprendiz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aprendiz_id")
    private Long id;
    
    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "correo_electreonico")
    private String correoElectronico;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "fecha_macimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "nivel_condicion")
    private String nivelCondicion;
    
    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    @OneToMany(mappedBy = "aprendiz", cascade = CascadeType.ALL)
    private List<ActividadEntrenamiento> actividadEntrenamientos;

    public Aprendiz() {
    }

    public Aprendiz(List<ActividadEntrenamiento> actividadEntrenamientos, String contraseña, String correoElectronico, Entrenador entrenador, LocalDate fechaNacimiento, String genero, Long id, String nivelCondicion, String nombreCompleto, String objetivo) {
        this.actividadEntrenamientos = actividadEntrenamientos;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        this.entrenador = entrenador;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.id = id;
        this.nivelCondicion = nivelCondicion;
        this.nombreCompleto = nombreCompleto;
        this.objetivo = objetivo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivelCondicion() {
        return nivelCondicion;
    }

    public void setNivelCondicion(String nivelCondicion) {
        this.nivelCondicion = nivelCondicion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public List<ActividadEntrenamiento> getActividadEntrenamientos() {
        return actividadEntrenamientos;
    }

    public void setActividadEntrenamientos(List<ActividadEntrenamiento> actividadEntrenamientos) {
        this.actividadEntrenamientos = actividadEntrenamientos;
    }
}
