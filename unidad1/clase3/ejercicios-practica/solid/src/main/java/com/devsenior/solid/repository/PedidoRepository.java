package com.devsenior.solid.repository;

import java.util.List;

import com.devsenior.solid.model.Pedido;

public interface PedidoRepository {
    void guardar(Pedido pedido);
    List<Pedido> listar();
}
