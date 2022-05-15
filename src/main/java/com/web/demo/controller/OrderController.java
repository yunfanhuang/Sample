package com.web.demo.controller;

import com.web.demo.entity.Investor;
import com.web.demo.entity.Portfolio;
import com.web.demo.entity.TStock;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio/order")
public class OrderController {

    @PersistenceContext
    protected EntityManager em;
    
    // 買進
    @GetMapping(value = {"/buy/{tstock_id}/{amount}"})
    @Transactional
    public String buy(HttpSession session, @PathVariable("tstock_id") String tstock_id, @PathVariable("amount") Integer amount) {
        Investor login_investor = (Investor)session.getAttribute("investor");
        Investor investor = em.find(Investor.class, login_investor.getId());
        if(investor == null) return "Investor None";
        TStock ts = em.find(TStock.class, tstock_id);
        if(ts == null) return "TStock None";
        
        int buyTotalCost = (int)(ts.getPrice().doubleValue() * amount);
        
        int balance = investor.getBalance() - buyTotalCost;
        if(balance < 0) {
            return "Insufficient balance";
        }
        investor.setBalance(balance);
        
        Portfolio po = new Portfolio();
        po.setInvestor(investor);
        po.settStock(ts);
        po.setCost(ts.getPrice().doubleValue());
        po.setAmount(amount);
        po.setDate(new Date());
        
        em.persist(investor);
        em.persist(po);
        em.flush(); // 取得最新 id
        
        return po.getId() + "";
    }
    
    // 賣出
    @GetMapping(value = {"/sell/{id}/{amount}"})
    @Transactional
    public String sell(HttpSession session, @PathVariable("id") Long id, @PathVariable("amount") Integer amount) {
        Investor login_investor = (Investor)session.getAttribute("investor");
        Investor investor = em.find(Investor.class, login_investor.getId());
        if(investor == null) return "Investor None";
        
        Portfolio po = em.find(Portfolio.class, id);
        if(po == null) return "Portfolio None";
        
        po.setAmount(po.getAmount() - amount);
        
        // 回滾利潤
        int profit = (int)(amount * po.gettStock().getPrice().doubleValue());
        investor.setBalance(investor.getBalance() + profit);
        
        em.persist(po);
        em.persist(investor);
        
        em.flush();
        return "OK";
    }

    
}
