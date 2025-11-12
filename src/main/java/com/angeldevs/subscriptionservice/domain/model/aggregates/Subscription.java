package com.angeldevs.subscriptionservice.domain.model.aggregates;

import com.angeldevs.subscriptionservice.domain.model.commands.CreateSubscriptionCommand;
import com.angeldevs.subscriptionservice.domain.model.entities.PaymentMethod;
import com.angeldevs.subscriptionservice.domain.model.entities.Plan;
import com.angeldevs.subscriptionservice.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class Subscription extends AuditableAbstractAggregateRoot<Subscription> {

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "organizer_id", nullable = false)
    private Long organizerId;

    public Subscription() {
    }

    public Subscription(CreateSubscriptionCommand command, Plan plan, PaymentMethod paymentMethod) {
        this.startDate = command.startDate();
        this.endDate = command.endDate();
        this.plan = plan;
        this.paymentMethod = paymentMethod;
        this.organizerId = command.organizerId();
    }

}

