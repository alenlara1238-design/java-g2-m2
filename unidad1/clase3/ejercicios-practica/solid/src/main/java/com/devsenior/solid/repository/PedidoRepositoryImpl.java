package com.devsenior.solid.repository;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.solid.model.Pedido;

public class PedidoRepositoryImpl implements PedidoRepository {

    //atributo
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void guardar(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public List<Pedido> listar() {
        return this.pedidos;
    }

    

}
