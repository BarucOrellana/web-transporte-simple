package com.transporte_simple.web.persistence.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
@Getter
@Setter
@NoArgsConstructor
public class UserRoleEntity {
    @Id
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 20)
    private String role;
    @Column(name = "granted_date",nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username",insertable = false, updatable = false)
    private UserEntity user;

}

