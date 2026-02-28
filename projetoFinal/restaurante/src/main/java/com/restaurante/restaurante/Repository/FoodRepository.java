package com.restaurante.restaurante.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//import com.model.restaurante;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restaurante.restaurante.model.Food; 

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{
    List<Food> findByTitle(String comida); // busca por nome
    List<Food> findById(Integer id);
    
} 
