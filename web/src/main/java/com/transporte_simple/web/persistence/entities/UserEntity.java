package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 200)
    private String password;
    @Value("false")
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean locked;
    @Value("false")
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean disable;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles;
    @OneToOne
    @JoinColumn(name = "id_seller")
    private SellerEntity seller;
    @OneToOne
    @JoinColumn(name = "id_provider")
    private ProviderEntity provider;
}
