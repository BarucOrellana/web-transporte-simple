package com.transporte_simple.web.persistence.entities;

import java.io.Serializable;
import java.util.Objects;

public class FreightEntityId implements Serializable {
    private Integer idFreight;
    private Integer idSeller;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreightEntityId that = (FreightEntityId) o;
        return Objects.equals(idFreight, that.idFreight) && Objects.equals(idSeller, that.idSeller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFreight, idSeller);
    }
}
