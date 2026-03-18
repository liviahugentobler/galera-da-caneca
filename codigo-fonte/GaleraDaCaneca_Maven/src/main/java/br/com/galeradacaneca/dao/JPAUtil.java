package br.com.galeradacaneca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utilitário JPA — mantém uma única instância de EntityManagerFactory.
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "GaleraDaCanecaPU";
    private static EntityManagerFactory factory;

    private JPAUtil() {}

    public static EntityManagerFactory getFactory() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return factory;
    }

    public static EntityManager getEntityManager() {
        return getFactory().createEntityManager();
    }

    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
