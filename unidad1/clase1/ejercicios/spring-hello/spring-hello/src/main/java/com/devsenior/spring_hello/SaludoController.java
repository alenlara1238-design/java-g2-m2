package com.devsenior.spring_hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class SaludoController {

    @GetMapping("/saludo")
    public String saludar(){
        return "<h1>Saludos desde el controlador</h1>";
    }

    @GetMapping("/saludo2")
    public String saludar(@RequestParam(value="name", required=true) String nombre,
                          @RequestParam(value="lastName", defaultValue ="Smith") String apellido){
        return String.format("<h1>Saludos %s %s </h1>", nombre, apellido);
    }

    @GetMapping("/doble/{numero}")
    public String getMethodeName(@PathVariable int numero){
        int respuesta = numero * 2;
        return String.format("<h1>El doble de %d es %d</h1>", numero, respuesta);
    }
}
