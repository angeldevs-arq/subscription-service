package com.angeldevs.subscriptionservice.domain.services;

import com.angeldevs.subscriptionservice.domain.model.aggregates.Subscription;
import com.angeldevs.subscriptionservice.domain.model.commands.CreateSubscriptionCommand;

public interface SubscriptionCommandService {
    Subscription handle(CreateSubscriptionCommand command);
}
