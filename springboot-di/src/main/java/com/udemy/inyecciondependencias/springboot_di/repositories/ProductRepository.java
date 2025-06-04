package com.udemy.inyecciondependencias.springboot_di.repositories;

import java.util.List;

import com.udemy.inyecciondependencias.springboot_di.models.Product;

public interface ProductRepository {

    public List<Product> findAll();

    public Product findById(Long id);

}
