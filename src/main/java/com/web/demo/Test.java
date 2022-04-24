/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.demo.entity.Classify;
import com.web.demo.entity.Employee;
import com.web.demo.entity.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author w94nj
 */
public class Test {
    static EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    static ObjectMapper om = new ObjectMapper();
    
    public static void main(String[] args) throws Exception {
        init();
    }
    
    public static void init() {
        
//        Classify classify1 = new Classify("管理員");
//        Classify classify2 = new Classify("員工");
                
        Employee employee1 = new Employee("admin", "1234", "管理員", "0987654321", true);
        Employee employee2 = new Employee("john", "1111", "小李", "0912345679", true);

        
        
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(employee2);
        em.getTransaction().commit();
        
        System.out.println("OK");
    }
}
