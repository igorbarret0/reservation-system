package com.igor.reservation_system.infrastructure.persistence.repositories;

import com.igor.reservation_system.infrastructure.persistence.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
