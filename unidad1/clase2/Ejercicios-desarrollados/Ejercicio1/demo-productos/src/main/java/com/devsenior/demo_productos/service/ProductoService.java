package com.devsenior.demo_productos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.demo_productos.model.Producto;
import com.devsenior.demo_productos.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {

    //atributo: dependencia
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repo){
       // this.repository = new ProductoRepository(); ¿por qué no hacemos esto?
        this.repository = repo;
    }

    //Crear con validaciones
    public Producto crear(Producto producto){
        //validamos el precio: no se puede crear un producto con precio < 0
        if(producto.getPrecio() < 0){
            throw new RuntimeException("El precio debe ser mayor a cero");
        }

        //no se puede añador un producto con un nombre existente
        boolean existe = repository.findAll().stream()
                        .anyMatch(p -> p.getNombre().equalsIgnoreCase(producto.getNombre()));

        if(existe){
            throw new RuntimeException("Ya existe un producto con ese nombre");
        }

       return repository.save(producto);
    }

    public List<Producto> listar(){
        return repository.findAll();
    }

    public List<Producto> productosCaros(){
       return  repository.findAll().stream()
                .filter(p -> p.getPrecio() > 100)
                .toList();
    }

    public List<Producto> buscarPorNombre(String nombre){
        return  repository.findAll().stream()
                        .filter(p-> p.getNombre().equalsIgnoreCase(nombre))
                        .toList();
    }

    public double promedioPrecios(){
       return repository.findAll().stream()
                    .mapToDouble(Producto::getPrecio) //p -> p.getPrecio()
                    .average()
                    .orElse(0);
    }

    public void eliminar(Long id){
        //verificamos la existencia del producto
        Producto producto = repository.findById(id)
                            .orElseThrow(()-> new RuntimeException("El producto no existe"));
        
         repository.deleteById(id);       
       }


}
