package org.example.service;

import org.example.entity.Cliente;
import org.example.repository.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Clase para la implementacion de la interfaz y los metodos CRUD para el Cliente
 */
public class ClienteService implements Repository<Cliente> {

    /**
     * Declaracion de la variable session para guardar o recibir objetos desde y hacia la base de datos
     */
    private final Session session;

    public ClienteService(Session session) {
        this.session = session;
    }

    /**
     * Metodo para realizar la insercion de un nuevo registro en la base de datos
     * @param cliente Objeto de tipo cliente definido en el paquete entity
     */
    @Override
    public void save(Cliente cliente) {
        Transaction trx = session.beginTransaction();
        session.save(cliente);
        System.out.println("Cliente Guardado Exitosamente con el id: " + cliente.getClienteId() +
                " y con identificacion: " + cliente.getIdentificacion());
        trx.commit();
    }

    /**
     * Metodo para mostrar todos los clientes almacenados en la base de datos por medio de HQL
     * @return la lista de clientes
     */
    @Override
    public List<Cliente> filtrarTodo() {
        Transaction trx = session.beginTransaction();
        //HQL
        List<Cliente> clientes = session.createQuery("FROM clientes", Cliente.class).getResultList();
        trx.commit();

        for (Cliente c: clientes) {
            return clientes;
        }
        return clientes;
    }

    /**
     * Metodo para mostrar un cliente especifico por medio de su identificacion
     * @param id hace referencia a la identificacion del cliente
     * @return el cliente con la identificacion pasada como parametro si existe en la base de datos
     */
    @Override
    public Cliente filtrarPorId(long id) {
        Transaction trx = session.beginTransaction();
        //HQL
        Cliente cliente = session.createQuery("FROM clientes WHERE identificacion=:id", Cliente.class).setParameter("identificacion", id).getSingleResult();
        trx.commit();
        return cliente;
    }

    /**
     * Metodo para actualizar un cliente
     * @param cliente Objeto de tipo cliente definido en el paquete entity
     */
    @Override
    public void update(Cliente cliente) {
        Transaction trx = session.beginTransaction();
        session.update(cliente);
        System.out.println("El Cliente con el id: " + cliente.getClienteId() +
                " y la identificacion: " + cliente.getIdentificacion() + "ha sido Actualizado Exitosamente ");
        trx.commit();
    }

    /**
     * Metodo para eliminar un cliente
     * @param identificaion del cliente a eliminar
     */
    @Override
    public void delete(long identificaion) {
        Transaction trx = session.beginTransaction();

        Cliente cliente = session.createQuery("from Cliente where identificacion = :identificacion", Cliente.class).setParameter("identificacion", identificaion).getSingleResult();

        if (cliente != null) {
            session.delete(cliente);
            System.out.println("El Cliente con el ID: " + cliente.getClienteId() +
                    " y la identificación: " + cliente.getIdentificacion() +
                    " ha sido eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún cliente con la identificación: " + identificaion);
        }
        trx.commit();

    }
}
