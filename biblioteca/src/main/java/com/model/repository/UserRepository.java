package com.model.repository;

import com.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.biblioteca.model.User;

@Repository // faz a requisição direto com a db
public interface UserRepository extends JpaRepository<User, Long>{

}
