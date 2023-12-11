package com.gatewway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        return serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange.pathMatchers("/eureka/**")
                        .permitAll()
                        .pathMatchers("/user/login/**").permitAll()
                        .pathMatchers("/user/create/**").hasAnyRole("admin","user")
                        .pathMatchers("/user/**").hasRole("admin")
                        .pathMatchers("/avis/all/**").permitAll()
                        .pathMatchers("/avis/**").hasAnyRole("admin","user")
                        .anyExchange().authenticated()
                ).oauth2ResourceServer((oauth) -> oauth
                        .jwt(jwtSpec ->jwtSpec .jwtAuthenticationConverter(jwtAuthConverter)))
                .build();
    }
}
