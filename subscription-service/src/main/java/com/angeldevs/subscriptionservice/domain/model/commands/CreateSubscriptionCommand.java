package com.angeldevs.subscriptionservice.domain.model.commands;

import java.util.Date;

public record CreateSubscriptionCommand(
        Date startDate,
        Date endDate,
        Long planId,
        Long paymentMethodId,
        Long organizerId
) {
}
