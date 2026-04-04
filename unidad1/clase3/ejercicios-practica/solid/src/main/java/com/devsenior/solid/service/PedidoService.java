package com.devsenior.solid.service;

import java.util.List;

import com.devsenior.solid.model.Pedido;

public interface PedidoService {
    //aqi defino los alcances de mi pedido
    void crearPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    double calcularTotal(Long pedidoId);
    double calcularTotalConDescuento(Long id, Descuento descuento);
}
