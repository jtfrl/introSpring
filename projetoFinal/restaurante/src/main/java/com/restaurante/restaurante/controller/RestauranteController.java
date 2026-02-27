package com.restaurante.restaurante.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restaurante.model.Food;
import com.restaurante.restaurante.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class RestauranteController {
    @Autowired
    private FoodService foodService;

    /*
    public RestauranteController(RestauranteService foodService){
        this.foodService=restauranteService;
    }
         */

    // definir @operation

    @PostMapping("/foods/get")
    public ResponseEntity<List<Food>> listarComidas(@RequestBody Food food){
        List<Food> foods=foodService.listarComidas();

        return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
    }


    @PostMapping("/foods/save")
    public ResponseEntity<Food> cadastrarFood(@RequestBody Food food){
        try{
            Food foodCad=foodService.cadastrarFood(food);
            if(foodCad==null){
                return new ResponseEntity<Food>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Food>(foodCad, HttpStatus.CREATED);
        }catch(RuntimeException e){
            return new ResponseEntity<Food>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/foods/get")
    public ResponseEntity<Food> buscarPorId(@PathVariable Long id){
        try{
            Food food=foodService.buscarPorId(id);
            return new ResponseEntity<Food>(food, HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/foods/update/{id}")
    // encontrar e salvar 
    public ResponseEntity<Food> atualizaFood(@PathVariable Long id, @RequestBody Food novaFood){
        try{   
            Food food=foodService.buscarPorId(id);
            if(food==null){
                 return new ResponseEntity<Food>(HttpStatus.BAD_REQUEST);
            }
        food.setNome(novaFood.getNome());
        food.setPreco(novaFood.getPreco());
        food.setImagem(novaFood.getImagem());

        Food foodAt=foodService.cadastrarFood(food);    
        
        return ResponseEntity.ok(foodAt);

        }catch(RuntimeException e){
            //uso de método construtor: avalia casos onde build não foi feito
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Food> deleteFood(@PathVariable Long id){
        try{
            Food food=foodService.buscarPorId(id);
            if(food==null){
               return ResponseEntity.notFound().build();
            }
            Boolean isRemoved=foodService.delete(id);
            if (!isRemoved) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();         
           }
             return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    
}
