package com.web.demo.entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("test");
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public static void shutdown() {
        emf.close();
    }
    
}