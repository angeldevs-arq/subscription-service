package com.angeldevs.subscriptionservice.interfaces.rest.resources.plan;

import java.math.BigDecimal;

public record PlanResource(
        Long id,
        String name,
        BigDecimal price,
        Integer eventQuant
) {
}
