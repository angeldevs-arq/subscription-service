package com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories;

import com.angeldevs.subscriptionservice.domain.model.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    boolean existsByName(String name);
}
