package com.gestion.GestionGym.Modelo;

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
    private Aprendiz aprendiz;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    @ManyToOne
    @JoinColumn(name = "categoria_entrenamiento_id")
    private CategoriaEntrenamiento categoriaEntrenamiento;

    public ActividadEntrenamiento() {
    }

    public ActividadEntrenamiento(Long id, String tipoEntrenamiento, String duracion, LocalDate fechaEntrenamiento, Aprendiz aprendiz, Entrenador entrenador, CategoriaEntrenamiento categoriaEntrenamiento) {
        this.id = id;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.duracion = duracion;
        this.fechaEntrenamiento = fechaEntrenamiento;
        this.aprendiz = aprendiz;
        this.entrenador = entrenador;
        this.categoriaEntrenamiento = categoriaEntrenamiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(String tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
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

    public CategoriaEntrenamiento getCategoriaEntrenamiento() {
        return categoriaEntrenamiento;
    }

    public void setCategoriaEntrenamiento(CategoriaEntrenamiento categoriaEntrenamiento) {
        this.categoriaEntrenamiento = categoriaEntrenamiento;
    }
}