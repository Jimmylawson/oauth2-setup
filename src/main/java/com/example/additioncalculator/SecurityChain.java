package com.example.additioncalculator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.OAuth2ResourceServerDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityChain {

    private String keySetUri;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http

                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers("/h2-console/**").permitAll()
                            .requestMatchers("/api/**").authenticated()
                            .anyRequest().permitAll();

                })
                .oauth2ResourceServer(ouath2 -> ouath2.jwt(Customizer.withDefaults()));

        return http.build();

    }

}
