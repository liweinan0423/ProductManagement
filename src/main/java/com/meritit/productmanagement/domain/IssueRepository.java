package com.meritit.productmanagement.domain;


import com.meritit.productmanagement.infastructure.PersistenceHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class IssueRepository {
    public List<Issue> list(int start, int limit) {
        EntityManager em = PersistenceHelper.getEntityManger();

        Query query = em.createQuery("select issue from Issue as issue");
        query.setFirstResult(start);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    public Long totalCount() {
        EntityManager em = PersistenceHelper.getEntityManger();

        Query query = em.createQuery("select count(*) from Issue");

        return (Long) query.getSingleResult();
    }

    public void save(Issue issue) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.persist(issue);
    }

    public Issue findById(String id) {
        EntityManager em = PersistenceHelper.getEntityManger();
        return em.find(Issue.class, id);
    }

    public void update(Issue issue) {
        EntityManager em = PersistenceHelper.getEntityManger();
        em.merge(issue);
    }
}
