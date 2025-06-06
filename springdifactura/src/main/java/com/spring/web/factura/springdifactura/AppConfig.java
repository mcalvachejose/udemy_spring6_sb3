package com.spring.web.factura.springdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.web.factura.springdifactura.models.Item;
import com.spring.web.factura.springdifactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {
        Product product = new Product("Proyector Sony", 200);
        Product product1 = new Product("Ventilador", 50);
        Product product2 = new Product("Radiador", 150);

        return Arrays.asList(new Item(product, 2) , new Item(product1, 2), new Item(product2, 3) );
    }
}
