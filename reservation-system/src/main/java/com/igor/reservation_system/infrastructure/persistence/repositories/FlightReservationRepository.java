package com.igor.reservation_system.infrastructure.persistence.repositories;

import com.igor.reservation_system.infrastructure.persistence.FlightReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightReservationRepository extends JpaRepository<FlightReservationEntity, Long> {
}
