package com.angeldevs.subscriptionservice.application.internal.queryservices;

import com.angeldevs.subscriptionservice.domain.model.entities.Plan;
import com.angeldevs.subscriptionservice.domain.model.queries.GetAllPlansQuery;
import com.angeldevs.subscriptionservice.domain.model.queries.GetPlanByIdQuery;
import com.angeldevs.subscriptionservice.domain.services.PlanQueryService;
import com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanQueryServiceImpl implements PlanQueryService {

    private final PlanRepository planRepository;

    public PlanQueryServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Plan handle(GetPlanByIdQuery query) {
        return planRepository.findById(query.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan with ID " + query.planId() + " not found."));
    }

    @Override
    public List<Plan> handle(GetAllPlansQuery query) {
        return planRepository.findAll();
    }
}
