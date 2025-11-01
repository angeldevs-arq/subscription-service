package com.angeldevs.subscriptionservice.application.internal.queryservices;

import com.angeldevs.subscriptionservice.domain.model.entities.PaymentMethod;
import com.angeldevs.subscriptionservice.domain.model.queries.GetPaymentMethodsByIdQuery;
import com.angeldevs.subscriptionservice.domain.services.PaymentMethodQueryService;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodQueryServiceImpl implements PaymentMethodQueryService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodQueryServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod handle(GetPaymentMethodsByIdQuery query) {
        return paymentMethodRepository.findById(query.paymentMethodId())
                .orElseThrow(() -> new RuntimeException("Payment Method not found for id: " + query.paymentMethodId()));
    }
}
