package com.angeldevs.subscriptionservice.domain.services;

import com.angeldevs.subscriptionservice.domain.model.commands.CreatePlanCommand;
import com.angeldevs.subscriptionservice.domain.model.entities.Plan;

public interface PlanCommandService {
    Plan handle(CreatePlanCommand command);
}
