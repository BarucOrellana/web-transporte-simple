package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.SellerEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface SellerRepository extends ListCrudRepository<SellerEntity, Integer> {

}
