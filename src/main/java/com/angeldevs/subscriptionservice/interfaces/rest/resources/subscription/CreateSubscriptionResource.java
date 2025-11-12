package com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription;

import java.util.Date;

public record CreateSubscriptionResource(
        Date startDate,
        Date endDate,
        Long planId,
        Long paymentMethodId,
        Long organizerId
) {
}
