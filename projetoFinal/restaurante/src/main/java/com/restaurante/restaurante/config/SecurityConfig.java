package com.restaurante.restaurante.config;

import org.springframework.security.config.Customizer;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

import org.springframework.http.HttpMethod;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CorsConfig corsConfig; // configuração para diferentes origens

    SecurityConfig(CorsConfig corsConfig) {
        this.corsConfig = corsConfig;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // configurações de API
        http
            .cors(Customizer.withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers->headers.frameOptions(frame->frame.disable()))
            .authorizeHttpRequests(auth->auth
            .requestMatchers(
                 "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html").permitAll()
             .requestMatchers("/h2-console/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/foods/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/users/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/foods/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/api/users/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            )   
            .httpBasic(Customizer.withDefaults());
            return http.build();
        
    }

    @Bean
    public UserDetailsService userDetailsService(){
        PasswordEncoder enc=PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        UserDetails user=User.builder()
            .username("usuario")
            .password(enc.encode("123456"))
            .roles("USER")
            .build();

        UserDetails admin=User.builder()
            .username("admin")
            .password(enc.encode("admin123"))
            .roles("ADMIN")
            .build();
            return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    
}
