package com.example.EmployeeInfoMgt.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/employees/create").permitAll()
                .requestMatchers("/api/employees/all").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }
}
