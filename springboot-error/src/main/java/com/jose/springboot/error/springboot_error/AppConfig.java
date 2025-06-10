package com.jose.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jose.springboot.error.springboot_error.models.Role;
import com.jose.springboot.error.springboot_error.models.User;

@Configuration
public class AppConfig {

    @Bean
    public List<User> lista() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Juan", "Dominguez", new Role("Carpintero")));
        users.add(new User(2L, "Hector", "Garcia"));
        users.add(new User(3L, "Ana", "Mangasio"));
        users.add(new User(4L, "Filomena", "Ochoa"));
        return users;
    }
}
