package com.example.API_Rest.controller;

import com.example.API_Rest.modelo.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class ProductoController {
    int contadorIDs = 0;

    public ProductoController(){
        //Añadimos algunos ejemplos a la lista
        productos.add(new Producto(contadorIDs++, "PortatilOscar", 1080));
        productos.add(new Producto(contadorIDs++, "TabletJavi", 800));
        productos.add(new Producto(contadorIDs++, "AuricularesJoseManuel", 100));

    }

    List<Producto> productos = new ArrayList<>();
    @GetMapping("/productos")
    public List<Producto> obtenerProducto(){
        System.out.println("*** LISTA DE PRODUCTOS ***");
        return productos;
    }

    @PostMapping("/productosnuevos")
    public Producto crearProducto(@RequestBody Producto producto){
        contadorIDs ++;
        producto.setId(contadorIDs);
        productos.add(producto);
        return producto;
    }
    /*
    * @RequestBody capturar el cuerpo de una petición HTTP y lo convierte en un objeto Java
    * @PathVariable captura una parte (dato-variable) de la URL (en este caso un ID)
    * */

    @PutMapping("/producto/{id}")
    public Producto actualizarProducto(@RequestBody Producto productoActualizado, @PathVariable int id){
        for (Producto producto : productos){
            if (producto.getId() == id){
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                return producto;
            }
        }
        return null;
    }

    @DeleteMapping("/productoborrado/{id}")
    public void eliminarProducto(@PathVariable int id){
        productos.removeIf(producto -> producto.getId() == id);
    }
}
