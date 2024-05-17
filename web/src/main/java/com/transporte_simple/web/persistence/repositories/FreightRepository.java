package com.transporte_simple.web.persistence.repositories;

import com.transporte_simple.web.persistence.entities.FreightEntity;
import com.transporte_simple.web.persistence.projection.FreightSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreightRepository extends ListCrudRepository<FreightEntity, Integer>{

    @Query(value = "SELECT f.id_freight AS idFreight, f.id_seller AS idSeller, s.name AS name, f.date AS date, f.destination AS destination, f.description AS description, "+
            "c.capacity AS capacity, p.product AS product " +
            "FROM freights f "  +
            "JOIN seller s ON f.id_seller = s.id_seller " +
            "JOIN capacity c ON f.id_capacity = c.id_capacity " +
            "JOIN products p ON f.id_product = p.id_product " +
            "WHERE f.id_seller = :idSeller", nativeQuery = true)
    List<FreightSummary> findBySeller(@Param("idSeller") int idSeller);
    @Query(value = "SELECT f.id_seller AS idSeller, s.name AS name, f.date AS date, f.destination AS destination, f.description AS description, " +
            "c.capacity AS capacity, p.product AS product " +
            "FROM freights f " +
            "JOIN seller s ON f.id_seller = s.id_seller " +
            "JOIN capacity c ON f.id_capacity = c.id_capacity " +
            "JOIN products p ON f.id_product = p.id_product", nativeQuery = true)
    List<FreightSummary> findFreightSummaries();
}
