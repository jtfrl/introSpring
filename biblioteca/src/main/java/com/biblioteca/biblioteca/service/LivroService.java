package com.biblioteca.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.repository.LivroRepository;
import com.model.Livro;

import jakarta.annotation.Nonnull;



@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    /* Método para cadastro dos livros
    @param livro
    @return cadastro do livro
     */
    public Livro cadastrarLivro(@Nonnull Livro livro){
        Livro livroSalvo=livroRepository.save(livro);
        return livroSalvo;
    }
    /*
    Método que lista todos os livros
    @return lista de livros cadastrados
    */
    public List<Livro> listarLivros(){
        return livroRepository.findAll().stream().collect(Collectors.toList());
    }

    public Livro buscarPorId(@Nonnull Long id){
        Livro livro =livroRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Livro não encontrado com o ID:"+id));

        return livro;
    }

    public List<Livro> buscarPorAutor(String autor){
        return livroRepository.findByAutorContainingIgnoreCase(autor)
        .stream()
        .collect(Collectors.toList());
    }

    public List<Livro> buscarPorTitulo(String titulo){
        return livroRepository.findByTituloContainingIgnoreCase(titulo)
        .stream()
        .collect(Collectors.toList());
    }
}
