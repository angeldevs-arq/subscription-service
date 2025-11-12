package com.angeldevs.subscriptionservice.domain.model.entities;

import com.angeldevs.subscriptionservice.domain.model.commands.CreatePaymentMethodCommand;
import com.angeldevs.subscriptionservice.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class PaymentMethod extends AuditableModel {

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "amount", nullable = false)
    private String ccv;

    @Column(name = "date_exp", nullable = false)
    private Date dateExp;

    public PaymentMethod() {
    }

    public PaymentMethod(CreatePaymentMethodCommand command) {
        this.cardNumber = command.cardNumber();
        this.ccv = command.ccv();
        this.dateExp = command.dateExp();
    }
}
