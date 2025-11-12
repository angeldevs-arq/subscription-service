package com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription;

import com.angeldevs.subscriptionservice.interfaces.rest.resources.paymentmethod.PaymentMethodResource;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.plan.PlanResource;

import java.util.Date;

public record GetSubscriptionByOrganizerResource(
        Long id,
        Date startDate,
        Date endDate,
        Long organizerId,
        PlanResource plan,
        PaymentMethodResource paymentMethod
) {
}
