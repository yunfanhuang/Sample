/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo.repository;

import com.web.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author w94nj
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
