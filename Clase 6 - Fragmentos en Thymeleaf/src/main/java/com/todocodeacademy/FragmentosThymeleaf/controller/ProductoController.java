package com.todocodeacademy.FragmentosThymeleaf.controller;

import com.todocodeacademy.FragmentosThymeleaf.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoController {

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {

        List<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Producto(1L, "Notebook IdeaPad", "Lenovo", 850000));
        listaProductos.add(new Producto(2L, "Mouse inalámbrico", "Logitech", 25000));
        listaProductos.add(new Producto(3L, "Teclado mecánico", "Redragon", 55000));
        listaProductos.add(new Producto(4L, "Monitor 24 pulgadas", "Samsung", 210000));
        listaProductos.add(new Producto(5L, "Auriculares", "Sony", 78000));

        model.addAttribute("listaProductos", listaProductos);

        return "productos";
    }
}
