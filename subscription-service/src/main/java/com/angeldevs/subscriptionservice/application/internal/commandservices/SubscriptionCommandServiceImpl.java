package com.angeldevs.subscriptionservice.application.internal.commandservices;

import com.angeldevs.subscriptionservice.domain.model.aggregates.Subscription;
import com.angeldevs.subscriptionservice.domain.model.commands.CreateSubscriptionCommand;
import com.angeldevs.subscriptionservice.domain.services.SubscriptionCommandService;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.PlanRepository;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionCommandServiceImpl implements SubscriptionCommandService {

    private final SubscriptionRepository subscriptionRepository;
    private final PlanRepository planRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    public SubscriptionCommandServiceImpl(SubscriptionRepository subscriptionRepository, PlanRepository planRepository, PaymentMethodRepository paymentMethodRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.planRepository = planRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public Subscription handle(CreateSubscriptionCommand command) {

        var plan = planRepository.findById(command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan not found."));

        var paymentMethod = paymentMethodRepository.findById(command.paymentMethodId())
                .orElseThrow(() -> new IllegalArgumentException("Payment Method not found."));

        var subscription = new Subscription(command, plan, paymentMethod);

        try {
            subscriptionRepository.save(subscription);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving course: " + e.getMessage());
        }
        return subscription;
    }

}
