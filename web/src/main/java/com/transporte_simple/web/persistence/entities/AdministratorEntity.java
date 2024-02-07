package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "administrators")
public class AdministratorEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
}
