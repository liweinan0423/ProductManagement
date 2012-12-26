package com.meritit.productmanagement.domain;

import com.meritit.productmanagement.infastructure.PersistenceUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductRepository {

    public void save(Product product) {
        EntityManager em = PersistenceUtils.getEntityManger();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(product);
        transaction.commit();
        em.close();
    }

    public Product findById(String id) {
        EntityManager em = PersistenceUtils.getEntityManger();
        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }
}