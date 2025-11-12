package com.angeldevs.subscriptionservice.interfaces.rest.resources.paymentmethod;

import java.util.Date;

public record PaymentMethodResource(
        Long id,
        String cardNumber,
        String ccv,
        Date dateExp
) {
}
