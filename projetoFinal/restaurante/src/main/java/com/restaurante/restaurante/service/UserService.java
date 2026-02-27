package com.restaurante.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurante.restaurante.Repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserService {
    @Autowired
    private UserRepository userRepository;

    
    
}
