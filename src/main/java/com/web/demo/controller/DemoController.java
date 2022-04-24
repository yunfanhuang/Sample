/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo.controller;

import com.web.demo.entity.Employee;
import com.web.demo.entity.Product;
import com.web.demo.entity.Purchase;
import com.web.demo.entity.Sales;
import com.web.demo.repository.EmployeeRepository;
import com.web.demo.repository.ProductRepository;
import com.web.demo.repository.PurchaseRepository;
import com.web.demo.repository.SalesRepository;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author w94nj
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping(value = {"/product", "/product/{id}", "/product/{name}/{id}"})
    public String readProduct(Model model,
            @PathVariable Optional<Integer> id,
            @PathVariable Optional<String> name) {
        String _method = "POST";
        Product product = new Product();
        if (id.isPresent()) {
            product = productRepository.findOne(id.get());
            _method = "PUT";
            if (name.isPresent() && name.get().equals("delete")) {
                _method = "DELETE";
            }
        }
        model.addAttribute("_method", _method);
        model.addAttribute("product", product);
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }
    
    @PostMapping(value = {"/product"})
    public String createProduct(@ModelAttribute("product") Product product, HttpSession session) {
        // 取得操作的使用者
        Employee employee = employeeRepository.getByName(session.getAttribute("username") + "");
        product.setEmployee(employee);
        // 將資料存入
        productRepository.save(product);
        // 重導頁面
        return "redirect: ./product";
    }
    
    @PutMapping(value = {"/product"})
    public String updateProduct(@ModelAttribute("product") Product product, HttpSession session) {
        // 取得操作的使用者
        Employee employee = employeeRepository.getByName(session.getAttribute("username") + "");
        product.setEmployee(employee);
        // 修改資料
        productRepository.saveAndFlush(product);
        // 重導頁面
        return "redirect: ./product";
    }
    
    @DeleteMapping(value = {"/product"})
    public String deleteProduct(@ModelAttribute("product") Product product) {
        // 刪除資料
        productRepository.delete(product.getId());
        // 重導頁面
        return "redirect: ./product";
    }
    
    // 讀取進貨
    @GetMapping(value = {"/purchase"})
    public String readPurchase(Model model) {
        model.addAttribute("purchases", purchaseRepository.findAll());
//        model.addAttribute("inventories2", inventory2Repository.findAll());
        return "purchase";
    }
    
    // 讀取銷貨
    @GetMapping(value = {"/sales"})
    public String readSales(Model model) {
        model.addAttribute("sales", salesRepository.findAll());
//        model.addAttribute("inventories2", inventory2Repository.findAll());
        return "sales";
    }
    
    // 進貨
    @PostMapping(value = {"/purchase"},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPurchase(@RequestBody MultiValueMap<String, String> form, HttpSession session) {
        // 取得表單資料
        Integer pid = Integer.parseInt(form.getFirst("pid"));
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        Integer price = Integer.parseInt(form.getFirst("price"));
        // 取得操作的使用者
        Employee employee = employeeRepository.getByName(session.getAttribute("username") + "");
        // 建立 Purchase 物件
        Purchase purchase = new Purchase();
        purchase.setProduct(productRepository.findOne(pid));
        purchase.setPrice(price);
        purchase.setQuantity(quantity);
        purchase.setEmployee(employee);
        // 儲存
        purchaseRepository.saveAndFlush(purchase);
        return "redirect: ./purchase";
    }

    // 銷貨
    @PostMapping(value = {"/sales"},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createSales(@RequestBody MultiValueMap<String, String> form, HttpSession session) {
        // 取得表單資料
        Integer pid = Integer.parseInt(form.getFirst("pid"));
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        Integer price = Integer.parseInt(form.getFirst("price"));
        // 取得操作的使用者
        Employee employee = employeeRepository.getByName(session.getAttribute("username") + "");
        // 建立 Sales 物件
        Sales sales = new Sales();
        sales.setProduct(productRepository.findOne(pid));
        sales.setPrice(price);
        sales.setQuantity(quantity);
        sales.setEmployee(employee);
        // 儲存
        salesRepository.saveAndFlush(sales);
        return "redirect: ./sales";
    }
}
