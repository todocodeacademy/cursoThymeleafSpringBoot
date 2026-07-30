package com.todocodeacademy.Ferreteria.controller;

import com.todocodeacademy.Ferreteria.model.Producto;
import com.todocodeacademy.Ferreteria.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Este código proviene de un proyecto realizado en TodoCode
//https://todocodeacademy.com en el curso de Desarrollo de Apis con Spring Boot
//Todos los derechos reservados

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    private final IProductoService prodServ;

    public ProductoRestController(IProductoService prodServ) {
        this.prodServ = prodServ;
    }

    //READ
    @GetMapping
    public List<Producto> traerProductos () {
        return prodServ.traerProductos();
    }

    //READ de producto específico
    @GetMapping("/{codProd}")
    public ResponseEntity<?> buscarProducto(@PathVariable Long codProd) {

        Producto prod = prodServ.buscarProducto(codProd);

        if (prod == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encuentra un producto con ese código");
        }

        return ResponseEntity.ok(prod);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<?> crearProducto (@RequestBody Producto prod) {

        Producto productoCreado = prodServ.crearProducto(prod);

        if (productoCreado== null) {
            return ResponseEntity.badRequest()
                    .body("Los datos del producto no son válidos");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoCreado);

    }

    //UPDATE
    @PutMapping("/{codProd}")
    public ResponseEntity<?> editarProducto (@PathVariable Long codProd,
                                             @RequestBody Producto prodAModificar) {

        Producto prodEditado = prodServ.editarProducto(codProd, prodAModificar);

        if (prodEditado== null) {
            return ResponseEntity.badRequest()
                    .body("No fue posible editar el producto");
        }

        return ResponseEntity.ok(prodEditado);

    }

    //DELETE
    @DeleteMapping("/{codProd}")
    public ResponseEntity<String> eliminarProducto (@PathVariable Long codProd) {

        boolean eliminado = prodServ.eliminarProducto(codProd);

        if (eliminado==false) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un producto con el código: " + codProd);
        }

        return ResponseEntity.ok("Prodcuto eliminado correctamente");

    }


}
