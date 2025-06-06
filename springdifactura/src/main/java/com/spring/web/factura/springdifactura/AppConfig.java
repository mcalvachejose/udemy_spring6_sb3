package com.spring.web.factura.springdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.spring.web.factura.springdifactura.models.Item;
import com.spring.web.factura.springdifactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean("itemsInvoice")
    List<Item> itemsInvoice() {
        Product product = new Product("Proyector Sony", 200);
        Product product1 = new Product("Ventilador", 50);
        Product product2 = new Product("Radiador", 150);

        return Arrays.asList(new Item(product, 2) , new Item(product1, 2), new Item(product2, 3) );
    }

    @Bean("itemsInvoiceOficina")
    @Primary
    List<Item> itemsInvoiceOficina() {
        Product product = new Product("Mesa", 80);
        Product product1 = new Product("Silla", 150);
        Product product2 = new Product("Regleta", 10);
        Product product3 = new Product("Elevador de pantalla", 25);

        return Arrays.asList(new Item(product, 2) , new Item(product1, 2), new Item(product2, 3), new Item(product3, 4) );
    }
}
