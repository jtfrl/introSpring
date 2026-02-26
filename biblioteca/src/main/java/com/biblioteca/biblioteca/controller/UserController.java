package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.dto.UserDTO;
import com.biblioteca.biblioteca.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    @Autowired

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> cadastrarUsuario(@RequestBody UserDTO userDTO){
        try{
            UserDTO userCadastrado=userService.cadastraUserDTO(userDTO);
            if(userCadastrado==null){
                return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<UserDTO>(userCadastrado, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<UserDTO>(null);
        }
    }
    
}
