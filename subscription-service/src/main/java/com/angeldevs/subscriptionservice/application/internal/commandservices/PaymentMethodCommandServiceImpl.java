package com.angeldevs.subscriptionservice.application.internal.commandservices;

import com.angeldevs.subscriptionservice.domain.model.commands.CreatePaymentMethodCommand;
import com.angeldevs.subscriptionservice.domain.model.entities.PaymentMethod;
import com.angeldevs.subscriptionservice.domain.services.PaymentMethodCommandService;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodCommandServiceImpl implements PaymentMethodCommandService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodCommandServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod handle(CreatePaymentMethodCommand command) {

        var paymentMethod = new PaymentMethod(command);

        try {
            paymentMethodRepository.save(paymentMethod);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving course: " + e.getMessage());
        }
        return paymentMethod;
    }
}
