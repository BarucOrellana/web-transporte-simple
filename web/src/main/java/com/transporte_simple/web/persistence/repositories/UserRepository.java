package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
