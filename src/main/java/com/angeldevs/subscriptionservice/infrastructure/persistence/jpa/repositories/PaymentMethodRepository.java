package com.angeldevs.subscriptionservice.infrastructure.persistence.jpa.repositories;

import com.angeldevs.subscriptionservice.domain.model.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
