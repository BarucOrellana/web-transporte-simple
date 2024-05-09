package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.UserRoleService;
import com.transporte_simple.web.domain.service.UserService;
import com.transporte_simple.web.persistence.entities.UserEntity;
import com.transporte_simple.web.persistence.entities.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/new-account/provider")
public class UserProviderController {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserProviderController(UserService userService, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity) {
        if (userService.existByUsername(userEntity.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El nombre de usuario ya está en uso.");
        }


        UserEntity user = new UserEntity();
        user.setUsername(userEntity.getUsername());
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        user.setPassword(encodedPassword);
        user.setDisable(false);
        user.setLocked(false);
        user.setSeller(userEntity.getSeller());
        user.setProvider(userEntity.getProvider());
        userService.save(user);

        UserRoleEntity role = new UserRoleEntity();
        role.setUsername(userEntity.getUsername());
        role.setRole("PROVIDER");
        role.setGrantedDate(LocalDateTime.now());
        role.setUser(user);
        userRoleService.save(role);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente.");
    }
}

