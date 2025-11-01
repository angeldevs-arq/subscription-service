package com.angeldevs.subscriptionservice.interfaces.rest.resources.paymentmethod;

import java.util.Date;

public record CreatePaymentMethodResource(
        String cardNumber,
        String ccv,
        Date dateExp
) {
}
