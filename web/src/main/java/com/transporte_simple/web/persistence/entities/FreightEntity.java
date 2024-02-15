package com.transporte_simple.web.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "freights")
@IdClass(FreightEntity.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreightEntity {

    @Id
    @Column(name = "id_freight")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFreight;
    @Id
    @Column(name = "id_provider", nullable = false)
    private int idSeller;
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime date;
    @Column
    private String comments;
    @ManyToOne
    @JoinColumn(name = "id_seller", referencedColumnName = "id_seller", insertable = false, updatable = false)
    private SellerEntity freights;
    @ManyToOne
    @JoinColumn(name = "id_capacity", referencedColumnName = "id_capacity", insertable = false, updatable = false)
    private CapacityEntity capacityFreight;
    @Column
    private String destination;
}
