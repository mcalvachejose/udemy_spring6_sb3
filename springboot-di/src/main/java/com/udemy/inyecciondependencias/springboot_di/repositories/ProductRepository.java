package com.udemy.inyecciondependencias.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.udemy.inyecciondependencias.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Ram", 200L),
            new Product(2L, "CPU", 600L),
            new Product(3L, "HD", 100L),
            new Product(4L, "SSD", 70L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
