package com.example.todocodeacademy.ThymeleafProyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {

    @GetMapping("/")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/procesar")
    public String procesarFormulario(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad,
            Model model) {

        String nombreCompleto = nombre + " " + apellido;

        String tipoEdad;
        if (edad >= 18) {
            tipoEdad = "Mayor de edad";
        } else {
            tipoEdad = "Menor de edad";
        }

        // Enviamos datos a la vista
        model.addAttribute("nombreCompleto", nombreCompleto);
        model.addAttribute("edad", edad);
        model.addAttribute("tipoEdad", tipoEdad);

        return "resultado";
    }



}
