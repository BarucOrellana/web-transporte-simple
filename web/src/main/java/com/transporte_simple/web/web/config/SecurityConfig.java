package com.transporte_simple.web.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(customizeRequests -> {
                            customizeRequests
                                    .requestMatchers(HttpMethod.GET,"/transporte_simple/freights/**").permitAll()
                                    .requestMatchers(HttpMethod.POST, "/transporte_simple/freights/**").hasAnyRole("ADMIN", "SELLER")
                                    .requestMatchers(HttpMethod.PUT, "/transporte_simple/freights/**").hasAnyRole("ADMIN", "SELLER")
                                    .requestMatchers(HttpMethod.DELETE, "/transporte_simple/freights/**").hasAnyRole("ADMIN", "SELLER")
                                    .requestMatchers(HttpMethod.POST, "/transporte_simple/provider/**").hasAnyRole("ADMIN", "PROVIDER")
                                    .requestMatchers(HttpMethod.PUT, "/transporte_simple/provider/**").hasAnyRole("ADMIN", "PROVIDER")
                                    .requestMatchers(HttpMethod.POST, "/transporte_simple/seller/**").hasAnyRole("ADMIN", "SELLER")
                                    .requestMatchers(HttpMethod.PUT, "/transporte_simple/seller/**").hasAnyRole("ADMIN", "SELLER")
                                    .anyRequest()
                                    .authenticated();
                        }
                )
                .csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
