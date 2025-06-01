package com.udemy.inyecciondependencias.springboot_di.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.inyecciondependencias.springboot_di.models.Product;
import com.udemy.inyecciondependencias.springboot_di.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService service = new ProductService();

    @GetMapping("/list")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return service.findeById(id);
    }
}
