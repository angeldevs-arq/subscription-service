package com.angeldevs.subscriptionservice.domain.model.commands;

import java.util.Date;

public record CreatePaymentMethodCommand(
        String cardNumber,
        String ccv,
        Date dateExp
) {
}
