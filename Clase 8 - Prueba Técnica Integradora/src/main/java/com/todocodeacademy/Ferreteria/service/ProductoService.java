package com.todocodeacademy.Ferreteria.service;

import com.todocodeacademy.Ferreteria.model.Producto;
import com.todocodeacademy.Ferreteria.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository prodRepo;

    public ProductoService(IProductoRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Override
    public List<Producto> traerProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Producto buscarProducto(Long codProd) {

        return prodRepo.findById(codProd).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto prod) {

        //validación de que el producto no sea null
        if (prod==null) {
            return null;
        }

        //falta validar si cada uno de los elementos es null o no
        boolean valido = this.validarDatos(prod);

        if(valido == false) {
            return null;
        }


        // Id se genera automáticamente en la BD y con esto la devolvemos junto con el producto
       return prodRepo.save(prod);

    }

    @Override
    public Producto editarProducto(Long codProd, Producto prod) {
       //buscar si existe el producto
        Producto prodExistente = buscarProducto(codProd);

        //validar
        if (prodExistente==null) {
            return null;
        }

        //falta validar si cada uno de los elementos es null o no
        boolean valido = this.validarDatos(prod);

        if(valido == false) {
            return null;
        }

        //actualizamos los datos con el producto
        prodExistente.setCategoria(prod.getCategoria());
        prodExistente.setDescripcion(prod.getDescripcion());
        prodExistente.setMarca(prod.getMarca());
        prodExistente.setStock(prod.getStock());
        prodExistente.setPrecio(prod.getPrecio());
        prod.setNombre(prod.getNombre());

        return prodRepo.save(prodExistente);

    }

    @Override
    public boolean eliminarProducto(Long codProd) {

        Producto prodExistente = buscarProducto(codProd);

        if (prodExistente == null) {
            return false;
        }

        prodRepo.delete(prodExistente);
        return true;

    }

    public boolean validarDatos (Producto prod) {

        if (prod.getNombre() == null || prod.getNombre().isBlank()) {
            return false;
        }

        if (prod.getMarca() == null || prod.getMarca().isBlank()) {
            return false;
        }

        if (prod.getCategoria() == null || prod.getCategoria().isBlank()) {
            return false;
        }

        if (prod.getPrecio() == null || prod.getPrecio()<=0) {
            return false;
        }

        if (prod.getStock() <=0) {
            return false;
        }

return true;

    }
}
