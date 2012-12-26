package com.meritit.productmanagement.infastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtils {
    static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManger() {
        if (entityManagerFactory == null) {
            init();
        }

        return entityManagerFactory.createEntityManager();
    }

    private static void init() {
        Persistence.createEntityManagerFactory("ProductManagement");
    }

}
