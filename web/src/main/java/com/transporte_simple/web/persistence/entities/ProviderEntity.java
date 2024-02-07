package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.lang.reflect.Array;

@Entity
@Table(name = "provider")
public class ProviderEntity {

    private int id;
    private String name;
    private String password;
    private String rfc;
    private String email;
    private String phoneNumber;
    private String role;
    private ProductsEntity products;
    private CapacityEntity capacity;
    private FreightEntity freights;

}
