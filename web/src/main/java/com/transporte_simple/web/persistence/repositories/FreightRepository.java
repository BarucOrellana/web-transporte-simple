package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.FreightEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreightRepository extends ListCrudRepository<FreightEntity, Integer>{

    @Query(value = "SELECT * FROM freights WHERE id_seller = :id_seller", nativeQuery = true)
    List<FreightEntity> findBySeller(@Param("id_seller") Integer idSeller);

}
