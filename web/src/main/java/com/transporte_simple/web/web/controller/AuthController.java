package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.dto.UserDto;
import com.transporte_simple.web.domain.service.UserService;
import com.transporte_simple.web.web.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService user;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService user) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.user = user;
    }


    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDto dto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        String jwt = jwtUtil.create(dto.getUsername());
        if (this.user.existByUsername(dto.getUsername())){
            if (this.user.findIdSeller(dto.getUsername()) == null){
                Integer idProvider = this.user.findIdProvider(dto.getUsername());
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.AUTHORIZATION, jwt);
                headers.add("idProvider", idProvider.toString());
                return ResponseEntity.ok().headers(headers).build();
            }else {
                Integer idSeller = this.user.findIdSeller(dto.getUsername());
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.AUTHORIZATION, jwt);
                headers.add("idSeller", idSeller.toString());
                return ResponseEntity.ok().headers(headers).build();
            }
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
