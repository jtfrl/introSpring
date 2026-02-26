package com.biblioteca.biblioteca.config;

//import org.springframework.boot.security.autoconfigure.web.reactive.PathRequest;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;  // CORRECT
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers->headers.frameOptions(frame->frame.disable()))
            .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html").permitAll()
            .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                //.requestMatchers(PathRequest.toH2Console()).permitAll()       
                
                //.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
            //.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
            // métodos de acesso ao banco de dados
            .requestMatchers(HttpMethod.GET, "/api/livros/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/users/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/livros/**").hasRole("ADMIN")
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

}
