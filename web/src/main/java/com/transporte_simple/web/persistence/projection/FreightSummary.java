package com.transporte_simple.web.persistence.projection;

import java.time.LocalDate;

public interface FreightSummary {
    String getName();
    LocalDate getDate();
    String getDescription();
    String getDestination();
    String getCapacity();
    String getProduct();
}
