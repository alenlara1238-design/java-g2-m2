package com.devsenior.solid.model;

import java.util.List;

public class Pedido {
    private Long id;
    private List<Producto> productos;

    public Pedido(Long id, List<Producto> productos) {
        this.id = id;
        this.productos = productos;
    }

    public Long getId(){return id;}
    public List<Producto> getProductos(){
            return this.productos;
    }

    
    
}
