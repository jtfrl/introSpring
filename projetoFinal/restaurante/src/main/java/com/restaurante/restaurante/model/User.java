package com.restaurante.restaurante.model;

import org.springframework.security.core.userdetails.UserDetails;

//import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String getUsername(){
        return this.login;
    }

    @Override
    public String getPassword(){
        return this.senha;
    }

    @Override
    // uma classe desconhecida vai herdar de GrantedAuthority 
    // aqui seria uma coleção de usuários ('User')
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    //@Override AJUSTAR
    //public boolean isAccountNonExpirded() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    @Column(nullable=false, unique=true)
    private String login;
    //@Column(nullable = false, unique=true)
    //id??
    @Column(nullable = false)
    private String senha;
    


}
