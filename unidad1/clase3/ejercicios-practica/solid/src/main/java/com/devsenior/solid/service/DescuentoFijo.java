package com.devsenior.solid.service;

public class DescuentoFijo implements Descuento {

    private double valor;

    public DescuentoFijo(double valor){
        this.valor = valor;
    }

    @Override
    public double aplicar(double total) {
        return total - valor;
    }

    
}
