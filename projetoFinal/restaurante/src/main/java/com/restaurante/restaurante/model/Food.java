package com.restaurante.restaurante.model;

//import com.google.common.collect.Tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.annotation.Generated;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="foods")
public class Food {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // variaveis usadas no sql: title, price, image 
    public Food(String nome, Float preco, String imagem){
        this.nome=nome;
        this.preco=preco;
        this.imagem=imagem;
    }

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false)
    private Float preco;

    @Column(nullable=false)
    private String imagem;
}
