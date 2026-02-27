package com.restaurante.restaurante.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/endereco-aqui")
public class RestauranteController {
    private final RestauranteService restuaranteService;

    public RestauranteController(RestauranteService restauranteService){
        this.restuaranteService=restauranteService;
    }

    @GetMapping("path")
    //public ResponseEntity<>
    
}
