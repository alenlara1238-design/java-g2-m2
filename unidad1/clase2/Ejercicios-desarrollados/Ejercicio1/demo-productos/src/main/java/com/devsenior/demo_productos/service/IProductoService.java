package com.devsenior.demo_productos.service;

import java.util.List;

import com.devsenior.demo_productos.model.Producto;

public interface IProductoService {
    
    Producto crear(Producto p);

    List<Producto> listar();

    List<Producto> productosCaros();

}
