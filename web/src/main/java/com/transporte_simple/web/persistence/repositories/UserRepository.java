package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
}
