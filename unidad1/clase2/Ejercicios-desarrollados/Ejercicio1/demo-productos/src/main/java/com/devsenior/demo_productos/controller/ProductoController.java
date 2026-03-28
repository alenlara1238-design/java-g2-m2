package com.devsenior.demo_productos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.demo_productos.model.Producto;
import com.devsenior.demo_productos.service.ProductoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    //atributo de clase
    private final ProductoService service;

    //aqui estoy exigiendo que para que exista controlador, debe existir el servicio asociado.
    public ProductoController(ProductoService service){
        this.service = service;
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto){
            return service.crear(producto);     
    }

    @GetMapping
    public List<Producto> listar(){
        return service.listar();
    }

    @GetMapping("/caros")
    public List<Producto> caros(){
        return service.productosCaros();
    }

    @GetMapping("/buscar")
    public List<Producto> buscar(@RequestParam String texto){
        return service.buscarPorNombre(texto);
    }

    @GetMapping("/promedio")
    public double promedio(){
        return service.promedioPrecios();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }

}   
