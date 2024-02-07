package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller")
public class SellerEntity {

    private int id;
    private String name;
    private String password;
    private String rfc;
    private String email;
    private String phone_number;
    private String role;
    private ProductsEntity products;
    private FreightEntity freights;
}
