/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo.controller;

import com.web.demo.entity.Employee;
import java.util.Date;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author w94nj
 */
public class EmployeeController {
    @PersistenceContext
    protected EntityManager em;
    
    @PostMapping(value = {"/", "/add"})
    @Transactional
    public Employee add(@RequestBody Map<String, String> map) {
        Employee employee = new Employee();
        employee.setUsername(map.get("username"));
        employee.setPassword(map.get("password"));
        employee.setName(map.get("name"));
        employee.setPhone(map.get("phone"));
        employee.setDate(new Date());
        employee.setState(Boolean.FALSE);
        
        em.persist(employee);
        
        // 取得最新 id
        em.flush();
        Long id = employee.getId();
           
        
        return employee;
    }
}
