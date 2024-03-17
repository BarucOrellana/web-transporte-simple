package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, String> {

}
