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
    private String rfc;
    @Column(nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FreightEntity> freights;
    @OneToOne(mappedBy = "seller")
    private UserEntity user;
}
