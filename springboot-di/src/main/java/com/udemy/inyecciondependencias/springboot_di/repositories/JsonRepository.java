package com.udemy.inyecciondependencias.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.inyecciondependencias.springboot_di.models.Product;

public class JsonRepository implements ProductRepository{

    List<Product> list;

    public JsonRepository(){
        Resource resourece = new ClassPathResource("product.json");
        readValue(resourece);
    }

      public JsonRepository(Resource resourece){
        readValue(resourece);
    }

    private void readValue(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
