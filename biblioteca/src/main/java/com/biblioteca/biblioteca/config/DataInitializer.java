package com.biblioteca.biblioteca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.biblioteca.biblioteca.repository.LivroRepository;
import com.biblioteca.biblioteca.repository.UserRepository;
import com.model.Livro;
import com.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Cadastrar alguns livros iniciais para teste
        if (livroRepository.count() == 0) {
            Livro livro1 = new Livro(
                "Dom Casmurro",
                "Machado de Assis",
                "Romance clássico brasileiro que explora ciúme e ambiguidade"
            );
            
            Livro livro2 = new Livro(
                "1984",
                "George Orwell",
                "Distopia sobre vigilância governamental e controle social"
            );
            
            Livro livro3 = new Livro(
                "O Pequeno Príncipe",
                "Antoine de Saint-Exupéry",
                "Fábula filosófica sobre amizade e valores humanos"
            );
            
            // outros livros podem ser adicionados aqui


            livroRepository.save(livro1);
            livroRepository.save(livro2);
            livroRepository.save(livro3);
            
            System.out.println("Livros iniciais cadastrados com sucesso!");
        }
    
        // Cadastrar usuário administrador inicial
        User admin = new User(
            "admin",
            "admin@admin.com",
            "admin123",
            false
        );

        User commonUser = new User(
            "user",
            "user@user.com",
            "user123",
            true
        );

        userRepository.save(admin);
        userRepository.save(commonUser);
        System.out.println("Usuários iniciais cadastrados com sucesso!");
    }
}
