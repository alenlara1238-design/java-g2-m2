package com.devsenior.alara.model;

public class Post {
    private Long id;
    private String contenido;
    private EstadoPost estado;

    public Post(Long id, String contenido, EstadoPost estado) {
        this.id = id;
        this.contenido = contenido;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public EstadoPost getEstado() {
        return estado;
    }

    public void setEstado(EstadoPost estado) {
        this.estado = estado;
    }

    
    
}
