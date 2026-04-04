package com.devsenior.solid.service;

public class DescuentoFactory {
    public static Descuento crear(String tipo, double valor){
        switch (tipo.toLowerCase()) {
            case "porcentaje":
                    return new DescuentoPorcentaje(valor);
            case "fijo":
                return new DescuentoFijo(valor);
            default:
                throw new IllegalArgumentException("Tipo de descuento no valido");
        }
    }
}
