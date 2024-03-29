package com.transporte_simple.web.persistence.projection;

import java.time.LocalDateTime;

public interface FreightSummary {
    String getName();
    LocalDateTime getDate();
    String getDescription();
    String getDestination();
    String getCapacity();
    String getProduct();
}
