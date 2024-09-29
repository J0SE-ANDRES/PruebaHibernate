package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Cliente;
import org.example.entity.Factura;
import org.example.entity.Producto;
import org.example.service.ClienteService;
import org.example.service.FacturaService;
import org.example.service.ProductoService;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("Iniciando conexion MySQL  con Hibernate");
        Session session = HibernateConfig.getSession().openSession();

        // Instancias de las Clases facturaService, clienteService y productoService
        FacturaService facturaService = new FacturaService(session);
        ClienteService clienteService = new ClienteService(session);
        ProductoService productoService = new ProductoService(session);

        // Instancia de la clase Cliente
        Cliente cliente = new Cliente(353535, "Jose", "Torres", "Persona Natural", "Cartagena", "Barrio x, Mz y, Lt z", 3210213, "jose@gmail.com");
        Cliente cliente1 = new Cliente(222555, "Gabriela", "Diaz", "Persona Natural", "Barranquilla", "Barrio z, Mz y, Lt x", 3127213, "Gabriela@gmail.com");
        Cliente cliente2 = new Cliente(111444, "Andrea", "Torres", "Persona Natural", "Cali", "Barrio z, Mz x, Lt y", 3154213, "Andrea@gmail.com");

        // Referencia a la clase producto
        Producto producto;
        Producto producto1;
        Producto producto2;

        // Array de los diferenctes prodcutos
        ArrayList<Producto> productos = new ArrayList<>(Arrays.asList(
              // Instancia de la clase Producto
              producto = new Producto("Cereal", true, 5000, 10000),
              producto1 = new Producto("Leche Alqueria 1L X6 Unds", true, 35000, 140000),
              producto2 = new Producto("Milo", true, 4000, 20000)
        ));

        // Referencia a la clase producto
        Producto producto3;
        Producto producto4;
        Producto producto5;

        // Array de los diferenctes prodcutos
        ArrayList<Producto> productos1 = new ArrayList<>(Arrays.asList(
                // Instancia de la clase Producto
                producto3 = new Producto("Yogurt Griego 500Gr", true, 25000, 50000),
                producto4 = new Producto("Avena Alpina 250Gr X4 Unds", true, 12000, 60000),
                producto5 = new Producto("Queso Finesse 45Gr X30 Tajadas", true, 25000, 75000)
        ));

        // Referencia a la clase producto
        Producto producto6;
        Producto producto7;
        Producto producto8;

        // Array de los diferenctes prodcutos
        ArrayList<Producto> productos2 = new ArrayList<>(Arrays.asList(
                // Instancia de la clase Producto
                producto6 = new Producto("Whisky Macallan Double Cask", true, 2170000, 2170000),
                producto7 = new Producto("Cervexa Corona X6 Unds", true, 20000, 20000),
                producto8 = new Producto("Vino Tinto", true, 40000, 160000)
        ));

        // Referencia a la clase factura
        Factura factura1;
        Factura factura2;
        Factura factura3;

        // Array de las facturas
        ArrayList<Factura> facturas = new ArrayList<>(Arrays.asList(
                // Instancia de la clase Producto
                factura1 = new Factura(19, "Producto Lacteos y Granos", LocalDateTime.now(), 10, 171955, cliente, productos),
                factura2 = new Factura(19, "Producto Lacteos", LocalDateTime.now(), 15, 187127, cliente1, productos1),
                factura3 = new Factura(19, "Licores", LocalDateTime.now(), 30, 1817725, cliente2, productos2)
        ));

        System.out.println("\n");
        //Se almacenan los clientes en la base de datos
        clienteService.save(cliente);
        clienteService.save(cliente1);
        clienteService.save(cliente2);

        System.out.println("\n");

        // Se almacenan los productos en la base de datos
        productoService.save(producto);
        productoService.save(producto1);
        productoService.save(producto2);
        productoService.save(producto3);
        productoService.save(producto4);
        productoService.save(producto5);
        productoService.save(producto6);
        productoService.save(producto7);
        productoService.save(producto8);


        System.out.println("\n");

        // Se almacenan las facturas en la base de datos
        facturaService.save(factura1);
        facturaService.save(factura2);
        facturaService.save(factura3);

        // Actualizacion de un cliente
        clienteService.update(cliente1);

        session.close();
        System.out.println("Finalizando la conexion a MySQL con Hibernate");

    }
}