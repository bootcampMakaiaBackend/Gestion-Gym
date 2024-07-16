package com.gestion.GestionGym.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CategoriaEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_entrenamiento_id")
    private Long id;

    @Column(name = "nombre_categoria")
    private String nombre;

    @OneToMany(mappedBy = "categoriaEntrenamiento", cascade = CascadeType.ALL)
    private List<ActividadEntrenamiento> actividades;

    public CategoriaEntrenamiento() {
    }

    public CategoriaEntrenamiento(Long id, String nombre, List<ActividadEntrenamiento> actividades) {
        this.id = id;
        this.nombre = nombre;
        this.actividades = actividades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ActividadEntrenamiento> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadEntrenamiento> actividades) {
        this.actividades = actividades;
    }
}
