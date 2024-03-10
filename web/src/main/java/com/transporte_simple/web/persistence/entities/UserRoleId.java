package com.transporte_simple.web.persistence.entities;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleId implements Serializable {
    private String userName;
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(userName, that.userName) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, role);
    }
}