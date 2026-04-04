package com.devsenior.solid.service;

public class DescuentoPorcentaje implements Descuento{

    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje){
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicar(double total) {
        return total - (total*porcentaje);
    }

    
}
