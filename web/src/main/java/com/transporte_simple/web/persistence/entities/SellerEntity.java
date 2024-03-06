package com.transporte_simple.web.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "seller")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellerEntity {

    @Id
    @Column(name = "id_seller")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeller;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String rfc;
    @Column(nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String role;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "seller_products", joinColumns = @JoinColumn(name = "id_seller", referencedColumnName = "id_seller"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id_product"))
    private List<ProductsEntity> productsSeller;
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FreightEntity> freights;
}
