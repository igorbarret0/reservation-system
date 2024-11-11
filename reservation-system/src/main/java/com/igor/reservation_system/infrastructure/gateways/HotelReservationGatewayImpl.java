package com.igor.reservation_system.infrastructure.gateways;

import com.igor.reservation_system.core.entities.HotelReservation;
import com.igor.reservation_system.core.gateways.HotelReservationGateway;
import com.igor.reservation_system.infrastructure.mapper.HotelReservationMapper;
import com.igor.reservation_system.infrastructure.persistence.repositories.HotelReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelReservationGatewayImpl implements HotelReservationGateway {

    private HotelReservationRepository hotelReservationRepository;
    private HotelReservationMapper mapper;

    public HotelReservationGatewayImpl(HotelReservationRepository hotelReservationRepository, HotelReservationMapper mapper) {
        this.hotelReservationRepository = hotelReservationRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void makeHotelReservation(HotelReservation hotelReservation) {

        hotelReservationRepository.save(mapper.toHotelReservationEntityFromHotelReservation(hotelReservation));
    }

    @Override
    public HotelReservation getHotelReservationById(Long id) {

        var reservationFound = hotelReservationRepository.findById(id);
        return reservationFound.map(hotelReservationEntity ->
                mapper.toHotelReservationFromHotelReservationEntity(hotelReservationEntity))
                    .orElse(null);

    }

}
