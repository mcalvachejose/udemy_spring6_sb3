package com.jose.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.jose.springboot.error.springboot_error.models.User;

public interface UserService {

    public Optional<User> find(Long id);
    public List<User> findAll();
}
