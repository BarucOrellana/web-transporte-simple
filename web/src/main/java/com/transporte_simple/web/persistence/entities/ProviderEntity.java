package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "provider")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderEntity {

    @Id
    @Column(name = "id_provider")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvider;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String rfc;
    @Column(nullable = false)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private String role;
   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "provider_products", joinColumns = @JoinColumn(name = "id_provider", referencedColumnName = "id_provider"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id_product"))
    private List<ProductsEntity> productsProvider;
    @ManyToOne
    @JoinColumn(name = "id_capacity", referencedColumnName = "id_capacity", insertable = false, updatable = false)
    private CapacityEntity capacity;
}
