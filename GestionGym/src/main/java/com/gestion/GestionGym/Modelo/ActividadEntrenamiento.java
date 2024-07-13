package com.gestion.GestionGym.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "actividad_entrenamiento")
public class ActividadEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actividad_entrenamiento_id")
    private Long id;

    @Column(name = "tipo_entrenamiento")
    private String tipoEntrenamiento;

    @Column(name = "fecha_entrenamiento")
    private LocalDate fechaEntrenamiento;  // Formato yyyy-MM-dd

    @Column(name = "duracion")
    private String duracion;

    // TODO: Faltan los DTOs para filtrar informacion de los aprendices y entrenadores
    @ManyToOne
    @JoinColumn(name = "aprendiz_id")
    @JsonIgnore
    private Aprendiz aprendiz;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    @JsonIgnore
    private Entrenador entrenador;

    public ActividadEntrenamiento() {
    }

    public ActividadEntrenamiento(Long id, String tipoEntrenamiento, LocalDate fechaEntrenamiento, String duracion, Aprendiz aprendiz, Entrenador entrenador) {
        this.id = id;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.fechaEntrenamiento = fechaEntrenamiento;
        this.duracion = duracion;
        this.aprendiz = aprendiz;
        this.entrenador = entrenador;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(String tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaEntrenamiento() {
        return fechaEntrenamiento;
    }

    public void setFechaEntrenamiento(LocalDate fechaEntrenamiento) {
        this.fechaEntrenamiento = fechaEntrenamiento;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}