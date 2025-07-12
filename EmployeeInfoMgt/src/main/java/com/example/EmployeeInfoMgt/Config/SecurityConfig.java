package com.example.EmployeeInfoMgt.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/api/employees/create").permitAll()
                .requestMatchers("/api/employees/all").permitAll()
                .requestMatchers("/api/employees/search").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // optional - allows testing secured endpoints with basic auth

        return http.build();
    }
}
