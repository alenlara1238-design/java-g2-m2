package com.devsenior.demo_productos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.devsenior.demo_productos.model.Producto;

@Repository
public class ProductoRepository {
    // Atributo(s)
    private List<Producto> productos = new ArrayList<>();
    private Long contador = 1L;

    public List<Producto> findAll(){
        return productos;
    }

    public Optional<Producto> findById(Long id){
        //lanzamos la solicitud a la BD: query
        return productos.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }

    public Producto save(Producto producto){
        producto.setId(contador++);
        productos.add(producto);
        return producto;
    }

    public void deleteById(Long id){
        productos.removeIf(p -> p.getId().equals(id));
    }

}
