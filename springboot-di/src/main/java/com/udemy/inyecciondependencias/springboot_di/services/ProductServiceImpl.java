package com.udemy.inyecciondependencias.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.inyecciondependencias.springboot_di.models.Product;
import com.udemy.inyecciondependencias.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    public ProductServiceImpl() {
    }

    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImpuesto = p.getPrice()*1.25d;
            //Product newProd = new Product(p.getId(),p.getName(),priceImpuesto.longValue());
            
            // Product newProd = (Product) p.clone();
            // newProd.setPrice(priceImpuesto.longValue());
            // return newProd;
            
            p.setPrice(priceImpuesto.longValue());
            return p;
        }).collect(Collectors.toList());
    }

     @Override
    public Product findeById(Long id) {
        return repository.findById(id);
    }

    @Autowired
    public void setRepository(@Qualifier("productRepositoryImpl") ProductRepository repository) {
         this.repository = repository;
    }
}
