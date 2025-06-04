package com.udemy.inyecciondependencias.springboot_di.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.inyecciondependencias.springboot_di.models.Product;
import com.udemy.inyecciondependencias.springboot_di.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    public ProductController(ProductService service) {
        this.service = service;
    }

    private ProductService service;

    @GetMapping("/list")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return service.findeById(id);
    }
}
