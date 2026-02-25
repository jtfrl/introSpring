package com.biblioteca.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.biblioteca.biblioteca.service.LivroService;
import com.model.Livro;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins="*") // permite acesso de diferentes origens
public class LivroController {
    @Autowired
    private LivroService livroService;


    //checar qual import é preciso aqui
    @Operation{
        summary="Cadastrar um novo livro",
        description="Registra o livro na lista de livros cadastrados"
    }

    @ApiResponse{
        value={
            @ApiResponse(responseCode = 201, description = "Livro cadastrado com sucesso"),
            @ApiResponse(responseCode = 400, description = "Sintaxe incorreta")
        }
    }


    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro){
        try{
            Livro livroCadastro=livroService.cadastrarLivro(livro);
            if(livroCadastro==null){
                return new ResponseEntity<Livro>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Livro>(livroCadastro, HttpStatus.CREATED);
        }catch(RuntimeException e){
            return new ResponseEntity<Livro>(HttpStatus.BAD_REQUEST);
        }
        
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros(){
        List<Livro> livros=livroService.listarLivros();

        return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
        try{
            Livro livro=livroService.buscarPorId(id);

            return new ResponseEntity<Livro>(livro, HttpStatus.OK);

        }catch(RuntimeException e){
            return new ResponseEntity<Livro>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Livro>> buscarPorAutor(@PathVariable String autor){
        try{
            List<Livro> livro=livroService.buscarPorAutor(autor);
            return new ResponseEntity<List<Livro>>(livro, HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<List<Livro>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Livro>> buscarPorTitulo(@PathVariable String titulo){
        try{
            List<Livro> livro=livroService.buscarPorTitulo(titulo);
            return new ResponseEntity<List<Livro>>(livro, HttpStatus.OK);

        }catch(RuntimeException e){
            return new ResponseEntity<List<Livro>>(HttpStatus.NOT_FOUND);

        }
    }
}
