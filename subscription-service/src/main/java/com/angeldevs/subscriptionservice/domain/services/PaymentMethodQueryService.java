package com.angeldevs.subscriptionservice.domain.services;

import com.angeldevs.subscriptionservice.domain.model.entities.PaymentMethod;
import com.angeldevs.subscriptionservice.domain.model.queries.GetPaymentMethodsByIdQuery;

import java.util.List;

public interface PaymentMethodQueryService {
    PaymentMethod handle(GetPaymentMethodsByIdQuery query);
}
