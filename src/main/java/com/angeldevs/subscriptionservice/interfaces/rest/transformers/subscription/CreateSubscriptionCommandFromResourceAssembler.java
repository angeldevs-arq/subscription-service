package com.angeldevs.subscriptionservice.interfaces.rest.transformers.subscription;

import com.angeldevs.subscriptionservice.domain.model.commands.CreateSubscriptionCommand;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription.CreateSubscriptionResource;

public class CreateSubscriptionCommandFromResourceAssembler {
    public static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource) {
        return new CreateSubscriptionCommand(resource.startDate(),
                resource.endDate(), resource.planId(), resource.paymentMethodId(), resource.organizerId());
    }
}
