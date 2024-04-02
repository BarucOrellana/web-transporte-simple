package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "id_capacity", nullable = false)
    private Integer idCapacity;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String rfc;
    @Column(nullable = false)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "id_capacity", referencedColumnName = "id_capacity", insertable = false, updatable = false)
    private CapacityEntity capacity;
    @OneToOne(mappedBy = "provider")
    private UserEntity user;
}
