package com.angeldevs.subscriptionservice.domain.services;

import com.angeldevs.subscriptionservice.domain.model.aggregates.Subscription;
import com.angeldevs.subscriptionservice.domain.model.queries.GetSubscriptionByOrganizerIdQuery;

public interface SubscriptionQueryService {
    Subscription handle(GetSubscriptionByOrganizerIdQuery query);
}
