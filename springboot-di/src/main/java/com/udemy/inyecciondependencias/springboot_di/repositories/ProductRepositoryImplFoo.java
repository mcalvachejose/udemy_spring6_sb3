package com.udemy.inyecciondependencias.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.udemy.inyecciondependencias.springboot_di.models.Product;

@Repository

public class ProductRepositoryImplFoo implements ProductRepository{

    List<Product> data;

    public ProductRepositoryImplFoo(){
        this.data = Arrays.asList(
        new Product(1L, "FOO DATA", 800L),
        new Product(2L, "DUMMY TEXT", 700L)
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
