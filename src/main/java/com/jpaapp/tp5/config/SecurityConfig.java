package com.jpaapp.tp5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utilisation de BCrypt pour le hashage des mots de passe
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/login", "/register").permitAll() // Accès libre aux pages login et register
                .requestMatchers("/admin").hasRole("ADMIN") // Seuls les utilisateurs avec le rôle ADMIN peuvent accéder à /admin
                .anyRequest().authenticated() // Tout autre accès nécessite d'être authentifié
                .and()
                .formLogin()
                .loginPage("/login") // Page de login personnalisée
                .permitAll() // Permet à tous d'accéder à la page de login
                .and()
                .logout()
                .permitAll(); // Permet à tous de se déconnecter
    }
}
