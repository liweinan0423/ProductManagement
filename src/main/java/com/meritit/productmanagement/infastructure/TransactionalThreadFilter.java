package com.meritit.productmanagement.infastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class TransactionalThreadFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = PersistenceHelper.getEntityManger();
            transaction = em.getTransaction();
            transaction.begin();

            chain.doFilter(request, response);

            transaction.commit();
        } catch (Throwable t) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new ServletException(t);
        } finally {
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }

            PersistenceHelper.entityManager.remove();
        }
    }

    @Override
    public void destroy() {
    }
}
