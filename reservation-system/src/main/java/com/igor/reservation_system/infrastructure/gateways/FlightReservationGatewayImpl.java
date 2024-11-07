package com.igor.reservation_system.infrastructure.gateways;

import com.igor.reservation_system.core.entities.FlightReservation;
import com.igor.reservation_system.core.gateways.FlightReservationGateway;
import com.igor.reservation_system.infrastructure.mapper.FlightReservationMapper;
import com.igor.reservation_system.infrastructure.persistence.repositories.FlightReservationRepository;
import com.igor.reservation_system.infrastructure.persistence.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightReservationGatewayImpl implements FlightReservationGateway {

    private FlightReservationRepository flightReservationRepository;
    private FlightReservationMapper mapper;
    private UserRepository userRepository;

    public FlightReservationGatewayImpl(FlightReservationRepository reservationRepository, FlightReservationMapper mapper,
                                        UserRepository userRepository) {
        this.flightReservationRepository = reservationRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void makeFlightReservation(FlightReservation flightReservation) {

       flightReservationRepository.save(mapper.toFlightReservationEntityFromFlightReservationEntity(flightReservation));

    }
}
