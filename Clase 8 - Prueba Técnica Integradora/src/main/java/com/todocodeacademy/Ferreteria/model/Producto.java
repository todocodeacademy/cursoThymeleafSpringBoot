package com.todocodeacademy.Ferreteria.model;

import jakarta.persistence.*;

@Entity
public class Producto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long codProducto;
private String nombre;
private String marca;
private String categoria;
private Double precio;
private int stock;
private String descripcion;

    public Producto() {
    }

    public Producto(Long codProducto, String nombre, String marca, String categoria, Double precio, int stock, String descripcion) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
