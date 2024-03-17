package com.transporte_simple.web.domain.service;

import com.transporte_simple.web.persistence.entities.UserRoleEntity;
import com.transporte_simple.web.persistence.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRoleEntity save(UserRoleEntity userRole){
        return this.userRoleRepository.save(userRole);
    }
}
