package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsEntity {

    private int id;
    private boolean chemical;
    private boolean agroChemical;
    private boolean dangerous;
    private boolean rawMaterials;
    private boolean other;

}
