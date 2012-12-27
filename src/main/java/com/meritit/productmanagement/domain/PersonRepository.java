package com.meritit.productmanagement.domain;

import com.meritit.productmanagement.infastructure.PersistenceHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonRepository {

    public void save(Person person) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.persist(person);
    }

    public Person findById(String id) {
        EntityManager em = PersistenceHelper.getEntityManger();
        Person person = em.find(Person.class, id);
        return person;
    }

    public List<Person> list(int start, int limit) {
        EntityManager em = PersistenceHelper.getEntityManger();
        Query query = em.createQuery("select p from Person as p");
        query.setFirstResult(start);
        query.setMaxResults(limit);
        List list = query.getResultList();
        return list;
    }

    public int totalCount() {
        EntityManager em = PersistenceHelper.getEntityManger();
        Query query = em.createQuery("select count(*) from Person");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    public void delete(String id) {
        delete(findById(id));
    }

    private void delete(Person person) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.remove(person);
    }

    public void update(Person person) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.merge(person);
    }
}