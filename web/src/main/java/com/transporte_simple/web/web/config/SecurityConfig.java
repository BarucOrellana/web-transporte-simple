package com.transporte_simple.web.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(customizeRequests -> {
                            customizeRequests
                                    .requestMatchers("/transporte_simple/auth/**").permitAll()
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
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
