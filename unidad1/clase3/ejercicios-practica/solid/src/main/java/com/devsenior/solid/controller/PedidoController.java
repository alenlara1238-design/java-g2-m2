package com.devsenior.solid.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.solid.model.Pedido;
import com.devsenior.solid.service.Descuento;
import com.devsenior.solid.service.DescuentoFactory;
import com.devsenior.solid.service.DescuentoFijo;
import com.devsenior.solid.service.DescuentoPorcentaje;
import com.devsenior.solid.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    @PostMapping
    public void crear(@RequestBody Pedido pedido){
        service.crearPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listar(){
        return service.listarPedidos();
    }

    @GetMapping("/{id}/total")
    public double total(@PathVariable Long id){
        return service.calcularTotal(id);
    }

    @GetMapping("/{id}/total-descuento")
    public double totalConDescuento(
                                    @PathVariable Long id,
                                    @RequestParam double valor,
                                    @RequestParam String tipo){

        Descuento descuento = DescuentoFactory.crear(tipo, valor);
        return service.calcularTotalConDescuento(id, descuento);
    }
}
