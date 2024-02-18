package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.ProviderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ProviderRepository extends ListCrudRepository<ProviderEntity, Integer> {

}
