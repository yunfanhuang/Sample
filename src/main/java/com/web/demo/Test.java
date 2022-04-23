/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    
    public static void init() {}
}
