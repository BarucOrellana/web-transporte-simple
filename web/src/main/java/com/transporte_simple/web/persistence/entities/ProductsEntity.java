package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsEntity {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    @Column
    private String product;
    @ManyToMany(mappedBy = "productsProvider")
    private List<ProviderEntity> providerProduct;
    @ManyToMany(mappedBy = "productsSeller")
    private List<SellerEntity> sellerProduct;

}
