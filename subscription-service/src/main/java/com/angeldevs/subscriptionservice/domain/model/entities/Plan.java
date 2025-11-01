package com.angeldevs.subscriptionservice.domain.model.entities;

import com.angeldevs.subscriptionservice.domain.model.commands.CreatePlanCommand;
import com.angeldevs.subscriptionservice.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
public class Plan extends AuditableModel {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "event_quant", nullable = false)
    private Integer eventQuant;

    public Plan() {}

    public Plan(CreatePlanCommand command) {
        this.name = command.name();
        this.price = command.price();
        this.eventQuant = command.eventQuant();
    }
}
