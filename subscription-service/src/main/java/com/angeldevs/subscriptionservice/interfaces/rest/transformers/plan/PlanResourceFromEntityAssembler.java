package com.angeldevs.subscriptionservice.interfaces.rest.transformers.plan;

import com.angeldevs.subscriptionservice.domain.model.entities.Plan;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.plan.PlanResource;

public class PlanResourceFromEntityAssembler {
    public static PlanResource toResourceFromEntity(Plan entity) {
        return new PlanResource(entity.getId(), entity.getName(), entity.getPrice(), entity.getEventQuant());
    }
}
