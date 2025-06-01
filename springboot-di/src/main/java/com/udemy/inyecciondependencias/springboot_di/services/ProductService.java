package com.udemy.inyecciondependencias.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;
import com.udemy.inyecciondependencias.springboot_di.models.Product;
import com.udemy.inyecciondependencias.springboot_di.repositories.ProductRepository;

public class ProductService {

    public ProductService() {
    }

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImpuesto = p.getPrice()*1.25d;
            // Product newProd = new Product(p.getId(),p.getName(),priceImpuesto.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceImpuesto.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

public Product findeById(Long id) {
    return repository.findById(id);
}

}
