package com.jose.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.springboot.error.springboot_error.models.Role;
import com.jose.springboot.error.springboot_error.models.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Juan", "Dominguez", new Role("Carpintero")));
        users.add(new User(2L, "Hector", "Garcia"));
        users.add(new User(3L, "Ana", "Mangasio"));
        users.add(new User(4L, "Filomena", "Ochoa"));
    }

    @Override
    public Optional<User> find(Long id) {
        User usuario = users.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        // if (usuario==null) {
        //     return Optional.empty();
        // } else {
        //     return Optional.of(usuario);
        // }
        return Optional.ofNullable(usuario);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
    
}
