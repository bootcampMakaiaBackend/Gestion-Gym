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

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "contraseña")
    private String contrasenia;

    @Column(name = "fecha_nacimiento")
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

    public Aprendiz(Long id, String nombreCompleto, String correoElectronico, String contrasenia, LocalDate fechaNacimiento, String genero, String objetivo, String nivelCondicion, Entrenador entrenador, List<ActividadEntrenamiento> actividadEntrenamientos) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.objetivo = objetivo;
        this.nivelCondicion = nivelCondicion;
        this.entrenador = entrenador;
        this.actividadEntrenamientos = actividadEntrenamientos;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getNivelCondicion() {
        return nivelCondicion;
    }

    public void setNivelCondicion(String nivelCondicion) {
        this.nivelCondicion = nivelCondicion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<ActividadEntrenamiento> getActividadEntrenamientos() {
        return actividadEntrenamientos;
    }

    public void setActividadEntrenamientos(List<ActividadEntrenamiento> actividadEntrenamientos) {
        this.actividadEntrenamientos = actividadEntrenamientos;
    }
}
