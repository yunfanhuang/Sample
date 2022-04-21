/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author w94nj
 */
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;
    
    @Column
    private String name;
    
    @Column
    private String phone;
    
    @Column
    private Classify classify;
    
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private boolean state;

    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone + ", classify=" + classify + ", date=" + date + ", state=" + state + '}';
    }
    
}
