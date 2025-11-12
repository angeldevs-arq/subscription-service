package com.angeldevs.subscriptionservice.domain.services;

import com.angeldevs.subscriptionservice.domain.model.commands.CreatePaymentMethodCommand;
import com.angeldevs.subscriptionservice.domain.model.entities.PaymentMethod;

public interface PaymentMethodCommandService {
    PaymentMethod handle(CreatePaymentMethodCommand command);
}
