package com.angeldevs.subscriptionservice.domain.services;


import com.angeldevs.subscriptionservice.domain.model.entities.Plan;
import com.angeldevs.subscriptionservice.domain.model.queries.GetAllPlansQuery;
import com.angeldevs.subscriptionservice.domain.model.queries.GetPlanByIdQuery;

import java.util.List;

public interface PlanQueryService {
    Plan handle(GetPlanByIdQuery query);

    List<Plan> handle(GetAllPlansQuery query);
}
