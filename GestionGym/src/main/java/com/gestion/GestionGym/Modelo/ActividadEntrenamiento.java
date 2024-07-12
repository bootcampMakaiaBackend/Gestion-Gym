package com.gestion.GestionGym.Modelo;

import jakarta.persistence.*;

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
    private String fechaEntrenamiento;

    @Column(name = "duracion")
    private String duracion;

    @ManyToOne
    @JoinColumn(name = "aprendiz_id")
    private Aprendiz aprendiz;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public ActividadEntrenamiento() {
    }

    public ActividadEntrenamiento(Aprendiz aprendiz, String duracion, Entrenador entrenador, String fechaEntrenamiento, Long id, String tipoEntrenamiento) {
        this.aprendiz = aprendiz;
        this.duracion = duracion;
        this.entrenador = entrenador;
        this.fechaEntrenamiento = fechaEntrenamiento;
        this.id = id;
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getFechaEntrenamiento() {
        return fechaEntrenamiento;
    }

    public void setFechaEntrenamiento(String fechaEntrenamiento) {
        this.fechaEntrenamiento = fechaEntrenamiento;
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
}
