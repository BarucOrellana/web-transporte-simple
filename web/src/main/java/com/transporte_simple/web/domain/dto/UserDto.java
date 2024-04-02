package com.transporte_simple.web.domain.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String username;
    private String password;
}
