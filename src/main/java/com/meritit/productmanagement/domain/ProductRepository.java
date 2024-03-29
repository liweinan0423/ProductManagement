package com.meritit.productmanagement.domain;

import com.meritit.productmanagement.infastructure.PersistenceHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductRepository {

    public void save(Product product) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.persist(product);
    }

    public Product findById(String id) {
        EntityManager em = PersistenceHelper.getEntityManger();
        Product product = em.find(Product.class, id);
        return product;
    }

    public List<Product> list(int start, int limit) {
        EntityManager em = PersistenceHelper.getEntityManger();
        Query query = em.createQuery("select p from Product as p");
        query.setFirstResult(start);
        query.setMaxResults(limit);
        List list = query.getResultList();
        return list;
    }

    public int totalCount() {
        EntityManager em = PersistenceHelper.getEntityManger();
        Query query = em.createQuery("select count(*) from Product");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    public void delete(String id) {
        delete(findById(id));
    }

    private void delete(Product product) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.remove(product);
    }

    public void update(Product product) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.merge(product);
    }
}