package com.udemy.inyecciondependencias.springboot_di.services;

import java.util.List;

import com.udemy.inyecciondependencias.springboot_di.models.Product;

public interface ProductService {

    public Product findeById(Long id);
    public List<Product> findAll();
}
