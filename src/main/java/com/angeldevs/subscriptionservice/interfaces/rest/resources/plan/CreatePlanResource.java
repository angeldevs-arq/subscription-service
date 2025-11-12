package com.angeldevs.subscriptionservice.interfaces.rest.resources.plan;

import java.math.BigDecimal;

public record CreatePlanResource(
        String name,
        BigDecimal price,
        Integer eventQuant
) {
}
