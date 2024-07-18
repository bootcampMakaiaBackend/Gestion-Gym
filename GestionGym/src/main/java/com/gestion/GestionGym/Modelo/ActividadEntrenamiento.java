package com.gestion.GestionGym.Modelo;

public class ActividadEntrenamiento {
    private Long id;
    private Long aprendizId;
    private Long entrenadorId;
    private String tipoEntrenamiento;
    private int duracionEntrenamiento;
    private String fechaEntrenamineto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAprendizId() {
        return aprendizId;
    }

    public void setAprendizId(Long aprendizId) {
        this.aprendizId = aprendizId;
    }

    public Long getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(Long entrenadorId) {
        this.entrenadorId = entrenadorId;
    }

    public int getDuracionEntrenamiento() {
        return duracionEntrenamiento;
    }

    public void setDuracionEntrenamiento(int duracionEntrenamiento) {
        this.duracionEntrenamiento = duracionEntrenamiento;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(String tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public String getFechaEntrenamineto() {
        return fechaEntrenamineto;
    }

    public void setFechaEntrenamineto(String fechaEntrenamineto) {
        this.fechaEntrenamineto = fechaEntrenamineto;
    }
}
