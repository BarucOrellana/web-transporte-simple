package com.transporte_simple.web.persistence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "freights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreightEntity {

    @Id
    @Column(name = "id_freight")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFreight;
    @Column(name = "id_seller", nullable = false)
    private Integer idSeller;
    @Column(name = "id_capacity", nullable = false)
    private Integer idCapacity;
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate date;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_seller", referencedColumnName = "id_seller", insertable = false, updatable = false)
    private SellerEntity seller;
    @ManyToOne
    @JoinColumn(name = "id_capacity", referencedColumnName = "id_capacity", insertable = false, updatable = false)
    private CapacityEntity capacity;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
    private ProductsEntity products;
    @Column
    private String destination;

}
