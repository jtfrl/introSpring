package com.restaurante.restaurante.service;

import com.restaurante.restaurante.Repository.FoodRepository;
import org.springframework.stereotype.Service;
import com.restaurante.restaurante.model.Food;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> listarComidas(){
        return foodRepository.findAll();
    }

    public Food cadastrarFood(Food food){
        return foodRepository.save(food);
    }

    public Food buscarPorId(Long id){
        return foodRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Comida não encontrada com id: "+ id)); 
    }

    public Boolean deleteFood(Long id){
        Boolean isDel=false;
        if(id==null){ 
            return isDel;
        }
        Food food=buscarPorId(id);
        foodRepository.delete(food);
        return !isDel;
    }

    public Food atualizarFood(Long id, Food food){
        Food atualFood=buscarPorId(id);

        // toma todos os dados existentes do atual
        atualFood.setNome(food.getNome());
        atualFood.setPreco(food.getPreco());
        atualFood.setImagem(food.getImagem());

        return foodRepository.save(atualFood);
    }
}
