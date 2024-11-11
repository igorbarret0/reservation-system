package com.igor.reservation_system.infrastructure.persistence.repositories;

import com.igor.reservation_system.infrastructure.persistence.HotelReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservationEntity, Long> {

    List<HotelReservationEntity> findByCheckOutDate(LocalDate checkOutDate);
}
