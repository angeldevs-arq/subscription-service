package com.angeldevs.subscriptionservice.domain.model.commands;

import java.math.BigDecimal;

public record CreatePlanCommand(
        String name,
        BigDecimal price,
        Integer eventQuant
) {
}
