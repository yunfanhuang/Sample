/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo.controller;

import com.web.demo.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author w94nj
 */
@Controller
@RequestMapping("/demo")
public class LoginController {

    @PersistenceContext
    protected EntityManager em;

    @RequestMapping(value = {"/login"})
    public String login(HttpSession session,
            @RequestHeader(value = "referer", required = false) String referer,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        System.out.println(referer);
        try {
            String sql = "Select i From Employee i Where i.username=:username";
            Employee employee = em.createQuery(sql, Employee.class)
                    .setParameter("username", username)
                    .getSingleResult();

            if (employee != null && employee.getPassword().equals(password)) {
                session.setAttribute("employee", employee);

                if (referer.contains("login.jsp")) {
                    return "redirect:/demo/index.jsp";
                }
                return "redirect:" + referer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.invalidate();
        return "redirect:/demo/login.jsp";
    }
}
