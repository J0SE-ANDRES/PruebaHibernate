package org.example.service;

import org.example.entity.Factura;
import org.example.repository.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Clase para la implementacion de la interfaz y los metodos CRUD para el Cliente
 */
public class FacturaService implements Repository<Factura> {

    /**
     * Declaracion de la variable session para guardar o recibir objetos desde y hacia la base de datos
     */
    private final Session session;

    public FacturaService(Session session) {
        this.session = session;
    }

    @Override
    public void save(Factura factura) {
        Transaction trx = session.beginTransaction();
        session.save(factura);
        System.out.println("La Factura con el id: " + factura.getFacturaId() +
                " se ha Guardado Exitosamente");
        trx.commit();
    }

    @Override
    public List<Factura> filtrarTodo() {
        Transaction trx = session.beginTransaction();
        //HQL
        List<Factura> facturas = session.createQuery("FROM facturas", Factura.class).getResultList();
        trx.commit();

        for (Factura f: facturas) {
            return facturas;
        }
        return facturas;
    }

    @Override
    public Factura filtrarPorId(long id) {
        Transaction trx = session.beginTransaction();
        //HQL
        Factura factura = session.createQuery("FROM facturas WHERE factura_id=:id", Factura.class).setParameter("factura_id", id).getSingleResult();
        trx.commit();
        return factura;
    }

    @Override
    public void update(Factura factura) {
        Transaction trx = session.beginTransaction();
        session.update(factura);
        System.out.println("La Factura con el id: " + factura.getFacturaId() +
                " se ha Actualizado Exitosamente (Que no deberia pero se hace a modo de ejemplo)");
        trx.commit();
    }

    @Override
    public void delete(long facturaId) {
        Transaction trx = session.beginTransaction();

        Factura factura = session.get(Factura.class, facturaId);

        if (factura != null) {
            session.delete(factura);
            System.out.println("La Factura con el ID: " + factura.getFacturaId() +
                    " se ha eliminado exitosamente (Que no deberia pero se hace a modo de ejemplo).");
        } else {
            System.out.println("No se encontró ninguna factura con el ID: " + facturaId);
        }

        trx.commit();
    }
}
