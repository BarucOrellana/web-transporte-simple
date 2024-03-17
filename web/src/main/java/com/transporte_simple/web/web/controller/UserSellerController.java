package com.transporte_simple.web.web.controller;
import com.transporte_simple.web.domain.dto.UserDto;
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
@RequestMapping("/new-account/seller")
public class UserSellerController {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserSellerController(UserService userService, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDTO) {
        if (userService.existByUsername(userDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El nombre de usuario ya está en uso.");
        }


        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);
        user.setDisable(false);
        user.setLocked(false);
        userService.save(user);

        UserRoleEntity role = new UserRoleEntity();
        role.setUsername(userDTO.getUsername());
        role.setRole("SELLER");
        role.setGrantedDate(LocalDateTime.now());
        role.setUser(user);
        userRoleService.save(role);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente.");
    }
}
