package com.model;

import jakarta.persistence.Column;

//package com.biblioteca.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.userdetails.UserDetails;

//@Getter
@Setter
@Entity
@Table(name = "usuarios") 
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private Boolean possuiMultas;


    @Column(nullable = false)

    private boolean isAdmin;

    public User(String username, String email, String password, boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.senha= password;
        this.isAdmin = isAdmin;
    }

    @Override
    public Collection<? extends extends GrantedAuthority> getAuth

    /*


    public User(String username, String email, String password, boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
        */
}