package com.udemy.inyecciondependencias.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.udemy.inyecciondependencias.springboot_di.repositories.JsonRepository;
import com.udemy.inyecciondependencias.springboot_di.repositories.ProductRepository;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public ProductRepository jsonRepository() {
        return new JsonRepository();
    }
}
