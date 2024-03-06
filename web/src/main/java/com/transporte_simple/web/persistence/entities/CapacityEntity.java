package com.transporte_simple.web.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "capacity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CapacityEntity {

    @Id
    @Column(name = "id_capacity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCapacity;
    @Column
    private String capacity;
    @OneToMany(mappedBy = "capacity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProviderEntity> providers;
    @OneToMany(mappedBy = "capacity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FreightEntity> freights;

}
