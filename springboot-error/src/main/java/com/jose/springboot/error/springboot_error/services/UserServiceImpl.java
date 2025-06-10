package com.jose.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jose.springboot.error.springboot_error.models.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;

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
