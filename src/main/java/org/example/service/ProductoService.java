package org.example.service;

import org.example.entity.Producto;
import org.example.repository.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Clase para la implementacion de la interfaz y los metodos CRUD para el Cliente
 */
public class ProductoService implements Repository<Producto> {

    /**
     * Declaracion de la variable session para guardar o recibir objetos desde y hacia la base de datos
     */
    private final Session session;

    public ProductoService(Session session) {
        this.session = session;
    }

    @Override
    public void save(Producto producto) {
        Transaction trx = session.beginTransaction();
        session.save(producto);
        System.out.println("Producto Guardado Exitosamente con el id: " + producto.getProductoId());
        trx.commit();
    }

    @Override
    public List<Producto> filtrarTodo() {
        Transaction trx = session.beginTransaction();
        //HQL
        List<Producto> productos = session.createQuery("FROM productos", Producto.class).getResultList();
        trx.commit();

        for (Producto p: productos) {
            return productos;
        }
        return productos;
    }

    @Override
    public Producto filtrarPorId(long id) {
        Transaction trx = session.beginTransaction();
        //HQL
        Producto producto = session.createQuery("FROM productos WHERE producto_id=:id", Producto.class).setParameter("productos_id", id).getSingleResult();
        trx.commit();
        return producto;
    }

    @Override
    public void update(Producto producto) {
        Transaction trx = session.beginTransaction();
        session.update(producto);
        System.out.println("El Producto con el id: " + producto.getProductoId() + " ha sido Actualizado Exitosamente ");
        trx.commit();
    }

    @Override
    public void delete(long productoId) {
        Transaction trx = session.beginTransaction();

        Producto producto = session.get(Producto.class, productoId);

        if (producto != null) {
            session.delete(producto);
            System.out.println("El Producto con el ID: " + producto.getProductoId() +
                    " ha sido eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún producto con el ID: " + productoId);
        }

        trx.commit();
    }
}
