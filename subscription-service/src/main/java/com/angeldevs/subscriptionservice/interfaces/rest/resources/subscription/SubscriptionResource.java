package com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription;

import java.util.Date;

public record SubscriptionResource(
        Long id,
        Date startDate,
        Date endDate,
        Long planId,
        Long paymentMethodId,
        Long organizerId
) {
}
