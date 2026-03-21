package com.devsenior.demo_crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.demo_crud.model.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/productos") //ruta base del controlador
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();
    private Long contadorId = 0L;


    //get -> listar todos los productos
    @GetMapping
    public List<Producto> listar(){
        return this.productos;
    }

    // get -> obtener un producto con id (/productos/10)
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id){
      /*
       return          productos.stream()
                        .filter(p -> p.getId()==id)
                        .reduce(); //tarea....
      */ 
        for(Producto producto: productos){
            if(producto.getId().equals(id)){
                return producto;
            }
        }
            return null;

    }

    // post -> crear un producto
    @PostMapping
    public Producto postMethodName(@RequestBody Producto producto) {
        producto.setId(contadorId++);
        productos.add(producto);
        return producto;
    }

    //actualizar todo un producto
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, 
                               @RequestBody Producto producto) {
        for(Producto p: productos){
            if(p.getId() == id){
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
                return p;
            }
        }
        return null;
    }
    
    //DELETE -> eliminar un producto
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(productos.removeIf(p -> p.getId().equals(id))){
            return "producto eliminado";
        }
        return "producto no encontrado";
    }

}
