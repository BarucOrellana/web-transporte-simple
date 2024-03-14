package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.FreightEntity;
import com.transporte_simple.web.persistence.entities.SellerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellerRepository extends ListCrudRepository<SellerEntity, Integer> {

    @Query(value = "SELECT * FROM seller WHERE id_seller = :id_seller", nativeQuery = true)
    SellerEntity getSeller(@Param("id_seller") Integer idSeller);

}
