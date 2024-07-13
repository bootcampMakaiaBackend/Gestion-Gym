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

    @Column(name = "mes")
    private int mes;

    @Column(name = "año")
    private int anio;

    @ManyToOne
    @JoinColumn(name = "aprendiz_id")
    private Aprendiz aprendiz;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public ActividadEntrenamiento() {
    }

    public ActividadEntrenamiento(Long id, int anio, int mes, String duracion, String fechaEntrenamiento, String tipoEntrenamiento, Entrenador entrenador, Aprendiz aprendiz) {
        this.id = id;
        this.anio = anio;
        this.mes = mes;
        this.duracion = duracion;
        this.fechaEntrenamiento = fechaEntrenamiento;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.entrenador = entrenador;
        this.aprendiz = aprendiz;
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

    public String getFechaEntrenamiento() {
        return fechaEntrenamiento;
    }

    public void setFechaEntrenamiento(String fechaEntrenamiento) {
        this.fechaEntrenamiento = fechaEntrenamiento;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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