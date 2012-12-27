package com.meritit.productmanagement.infastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceHelper {
    static EntityManagerFactory entityManagerFactory;

    public static ThreadLocal<EntityManager> entityManager = new ThreadLocal<EntityManager>();

    public static EntityManager getEntityManger() {
        if (entityManagerFactory == null) {
            init();
        }

        if (entityManager.get() == null) {
            entityManager.set(entityManagerFactory.createEntityManager());
        }

        return entityManager.get();
    }

    private static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ProductManagement");
    }

}
