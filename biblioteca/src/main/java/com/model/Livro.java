package com.model;

import com.google.common.collect.Tables;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.*;
import java.time.LocalDate;

/*
Classe que define a entidade Livro no sistema
@author jtfrl
@version 1.0

*/

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Livros") // chama a tabela livros no banco de dados
public class Livro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Livro(String titulo, String autor, String descricao){
        this.titulo=titulo;
        this.autor=autor;
        this.descricao=descricao;
    }

    @Column(nullable=false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(length = 1000)
    private String descricao;

    private LocalDate dataCadastro;


    
}
