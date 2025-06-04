package com.udemy.inyecciondependencias.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import com.udemy.inyecciondependencias.springboot_di.models.Product;

@Repository
@SessionScope
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Ram", 200L),
            new Product(2L, "CPU", 600L),
            new Product(3L, "HD", 100L),
            new Product(4L, "SSD", 70L)
        );
    }

     @Override
    public List<Product> findAll() {
        return data;
    }

     @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
