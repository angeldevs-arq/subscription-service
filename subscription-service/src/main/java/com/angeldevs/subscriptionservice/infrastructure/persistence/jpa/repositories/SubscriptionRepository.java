package com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories;

import com.angeldevs.subscriptionservice.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByOrganizerId(Long organizerId);
}
