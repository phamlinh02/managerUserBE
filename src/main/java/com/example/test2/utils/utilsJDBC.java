package com.example.test2.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class utilsJDBC {
    private static EntityManagerFactory factory;
    private static EntityManager em;

    private utilsJDBC() {
        // TODO Auto-generated constructor stub
    }

    public static EntityManager getEntityManager() {
        if ( em == null||!em.isOpen()) {
            getEntityManagerFactory();
            em = factory.createEntityManager();
        }
        em.clear();
        return em;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("Test2");
        }
        return factory;
    }
}
