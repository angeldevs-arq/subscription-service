package com.angeldevs.subscriptionservice.interfaces.rest.transformers.subscription;

import com.angeldevs.subscriptionservice.domain.model.aggregates.Subscription;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {
    public static SubscriptionResource toResourceFromEntity(Subscription entity) {
        return new SubscriptionResource(entity.getId(), entity.getStartDate(), entity.getEndDate(), entity.getPlan().getId(),
                entity.getPaymentMethod().getId(), entity.getOrganizerId());
    }
}
