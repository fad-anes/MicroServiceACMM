package com.gatewway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.Collections;


@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        CorsConfigurationSource configurationSource = new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(ServerWebExchange exchange) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                config.setAllowedMethods(Arrays.asList("GET", "PUT", "DELETE", "POST"));
                config.setAllowedHeaders(Arrays.asList("*"));
                return config;
            }
        };

        return serverHttpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/eureka/**").permitAll()
                        .pathMatchers("/user/login/**").permitAll()
                        .pathMatchers("/user/create/**").permitAll()
                        .pathMatchers("/user/one/").hasAnyRole("admin", "user")
                        .pathMatchers("/avis/all/**").permitAll()
                        .anyExchange()
                        .authenticated()
                )
                .oauth2ResourceServer(oauth -> oauth.jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(jwtAuthConverter)))
                .cors(cors -> cors.configurationSource(configurationSource))
                .build();
    }


}
