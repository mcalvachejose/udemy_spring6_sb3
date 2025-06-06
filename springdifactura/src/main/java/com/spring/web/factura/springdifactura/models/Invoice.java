package com.spring.web.factura.springdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
// @JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("itemsInvoice")
    private List<Item> items;

    public Invoice() {
        System.out.println("Costructor Invoice START");
        System.out.println("Cliete Cont " + client);
        System.out.println("Description Cont " + description);
        System.out.println("----------------");
    }

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura");
        System.out.println("Cliete Cont " + client);
        System.out.println("Description Cont " + description);
        client.setName(client.getName().concat("PEPE "));
        description = description.concat("de cliente : ").concat(client.getName()).concat(" " + client.getLastname());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo Invoice " + this);
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return items.stream()
        .map(item -> item.getImporte())                         // convierte el flujo a Integer en vez de objetos
        .reduce(0, (sum, importe) -> sum + importe);            // 0 es el valor inicia, despues (lamba expresion) 
    }
}
