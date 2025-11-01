package com.angeldevs.subscriptionservice.application.internal.commandservices;

import com.angeldevs.subscriptionservice.domain.model.commands.CreatePlanCommand;
import com.angeldevs.subscriptionservice.domain.model.entities.Plan;
import com.angeldevs.subscriptionservice.domain.services.PlanCommandService;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.PlanRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanCommandServiceImpl implements PlanCommandService {

    private final PlanRepository planRepository;

    public PlanCommandServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Plan handle(CreatePlanCommand command) {

        if (planRepository.existsByName(command.name())) {
            throw new IllegalArgumentException("Plan with this name already exists.");
        }

        var plan = new Plan(command);

        try {
            planRepository.save(plan);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving course: " + e.getMessage());
        }
        return plan;
    }
}
