package org.example.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase Para la Configuracion de Hibernate
 */
public class HibernateConfig {
    /**
     * Referencia de SessionFactory
     */
    private static final SessionFactory session;
    static {
        try {
            /**
             * Instacia de la session
             */
            session = new Configuration().configure().buildSessionFactory();

        } catch (HibernateException ex) {
            /**
             * Mensaje en caso de error a la hora de crear la configuracion
             */
            System.err.println("Error al crear la configuracion de Hibertnate: " + ex.getMessage());
            throw new ExceptionInInitializerError();
        }
    }
    /**
     * Clase para obtener la session
     * @return se retorna la session
     */
    public static SessionFactory getSession() {
        return session;
    }
}
