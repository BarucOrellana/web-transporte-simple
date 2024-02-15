package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "administrators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorEntity {

    @Id
    @Column(name = "id_admin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
}
