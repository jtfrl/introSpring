package com.restaurante.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restaurante.restaurante.Repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
@AllArgsConstructor
public class UserService implements UserDetailsService{ 
    //@Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        return userRepository.findByUsername(userName)
            .map(user->org.springframework.security.core.userdetails.User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .build())
        .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado: "+userName));
    }
    
}
