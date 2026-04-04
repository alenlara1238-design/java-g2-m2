package com.devsenior.solid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.solid.model.Pedido;
import com.devsenior.solid.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

    private PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Pedido> listarPedidos() {
        return repository.listar();
    }

    @Override
    public double calcularTotal(Long pedidoId) {

        //1. encontramos el pedido refrenciado(pedidoId)
        Pedido pedido = repository.listar().stream()
                                .filter(p -> p.getId().equals(pedidoId))
                                .findFirst()
                                .orElseThrow(()-> new RuntimeException("Pedido no encontrado"));
        
        //2. calculamos el total de ese pedido encontrado
        double total = pedido.getProductos().stream()
                        .map(producto -> producto.getPrecio())
                        .reduce(0.0, Double::sum);

        return total;
    }   


    @Override
    public void crearPedido(Pedido pedido) {
        repository.guardar(pedido);
    }

    public double calcularTotalConDescuento(Long pedidoId, Descuento descuento){
        double total = calcularTotal(pedidoId);
        return descuento.aplicar(total);
    }

}
