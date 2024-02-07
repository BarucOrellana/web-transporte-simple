package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Entity
@Table(name = "freights")
public class FreightEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime date;
    @Column
    private String comments;
    @Column
    private ProviderEntity provider;
    @Column
    private SellerEntity seller;
    @Column
    private String Destination;
}
