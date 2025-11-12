package com.angeldevs.subscriptionservice.application.internal.queryservices;

import com.angeldevs.subscriptionservice.domain.model.aggregates.Subscription;
import com.angeldevs.subscriptionservice.domain.model.queries.GetSubscriptionByOrganizerIdQuery;
import com.angeldevs.subscriptionservice.domain.services.SubscriptionQueryService;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionQueryServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription handle(GetSubscriptionByOrganizerIdQuery query) {
        return subscriptionRepository.findByOrganizerId(query.organizerId())
                .orElseThrow(() -> new RuntimeException("Subscription not found for userId: " + query.organizerId()));
    }
}
