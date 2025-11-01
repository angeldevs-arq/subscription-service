package com.angeldevs.subscriptionservice.interfaces.rest.transformers.paymentmethod;

import com.angeldevs.subscriptionservice.domain.model.entities.PaymentMethod;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.paymentmethod.PaymentMethodResource;

public class PaymentMethodResourceFromEntityAssembler {
    public static PaymentMethodResource toResourceFromEntity(PaymentMethod entity) {
        return new PaymentMethodResource(entity.getId(), entity.getCardNumber(), entity.getCcv(), entity.getDateExp());
    }
}
