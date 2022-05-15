package com.web.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Watch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String name;
    
    @ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "investor_id", referencedColumnName = "id")
    @JsonIgnoreProperties("watchs")
    private Investor investor;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "watch_tstock", 
            joinColumns = {
                @JoinColumn(name = "watch_id", 
                            nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "tStock_id", 
                            nullable = false, updatable = false)
            }
    )
    private Set<TStock> tStocks = new LinkedHashSet<>();

    public Watch() {
    }

    public Watch(String name, Investor investor) {
        this.name = name;
        this.investor = investor;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<TStock> gettStocks() {
        return tStocks;
    }

    public void settStocks(Set<TStock> tStocks) {
        this.tStocks = tStocks;
    }
    
    public Set<TStock> addtStock(TStock tStock) {
        tStocks.add(tStock);
        return tStocks;
    }
    
    public Set<TStock> removetStock(TStock tStock) {
        tStocks.remove(tStock);
        return tStocks;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Watch{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
