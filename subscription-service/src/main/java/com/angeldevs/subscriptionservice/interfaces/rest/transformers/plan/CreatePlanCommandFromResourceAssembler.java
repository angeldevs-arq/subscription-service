package com.angeldevs.subscriptionservice.interfaces.rest.transformers.plan;


import com.angeldevs.subscriptionservice.domain.model.commands.CreatePlanCommand;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.plan.CreatePlanResource;

public class CreatePlanCommandFromResourceAssembler {
    public static CreatePlanCommand toCommandFromResource(CreatePlanResource resource) {
        return new CreatePlanCommand(resource.name(), resource.price(), resource.eventQuant());
    }
}
