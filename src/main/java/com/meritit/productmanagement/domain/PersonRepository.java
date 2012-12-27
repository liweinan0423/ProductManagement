package com.meritit.productmanagement.domain;

import com.meritit.productmanagement.infastructure.PersistenceHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceUnit;
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

    public Person findByLoginAndPassword(String login, String password) throws LoginException {
        EntityManager em = PersistenceHelper.getEntityManger();
        Query query = em.createQuery("select person from Person as person where person.login = :login and person.password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);

        try {
            Person person = (Person) query.getSingleResult();
            return person;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new LoginException(e, "用户名不存在或者密码错误");
        } catch (NonUniqueResultException e) {
            e.printStackTrace();
            throw new LoginException(e, "用户名重复");
        }

        throw new RuntimeException("未知错误");

    }
}