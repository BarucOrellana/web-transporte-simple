package com.transporte_simple.web.domain.service;

import com.transporte_simple.web.persistence.entities.UserEntity;
import com.transporte_simple.web.persistence.entities.UserRoleEntity;
import com.transporte_simple.web.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity user){
        return this.userRepository.save(user);
    }

    public boolean existByUsername(String username){
        return this.userRepository.findByUsername(username).isPresent();
    }
}
