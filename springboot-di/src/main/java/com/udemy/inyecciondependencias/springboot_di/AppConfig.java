package com.udemy.inyecciondependencias.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

import com.udemy.inyecciondependencias.springboot_di.repositories.JsonRepository;
import com.udemy.inyecciondependencias.springboot_di.repositories.ProductRepository;

@Configuration
public class AppConfig {

    @Value("classpath:product.json")
    private Resource resourece;

    @Bean
    @Primary
    public ProductRepository jsonRepository() {
        return new JsonRepository(resourece);
    }
}
