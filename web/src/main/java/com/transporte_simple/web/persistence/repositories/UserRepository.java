package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);

    @Query(value = "SELECT id_seller FROM user WHERE username = :username", nativeQuery = true)
    Integer findIdSeller(@Param("username") String username);
    @Query(value = "SELECT id_provider FROM user WHERE username = :username", nativeQuery = true)
    Integer findIdProvider(@Param("username") String username);
}
