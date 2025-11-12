package com.angeldevs.subscriptionservice.interfaces.rest.transformers.paymentmethod;

import com.angeldevs.subscriptionservice.domain.model.commands.CreatePaymentMethodCommand;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.paymentmethod.CreatePaymentMethodResource;

public class CreatePaymentMethodCommandFromResourceAssembler {
    public static CreatePaymentMethodCommand toCommandFromResource(CreatePaymentMethodResource resource) {
        return new CreatePaymentMethodCommand(resource.cardNumber(), resource.ccv(), resource.dateExp());
    }
}
