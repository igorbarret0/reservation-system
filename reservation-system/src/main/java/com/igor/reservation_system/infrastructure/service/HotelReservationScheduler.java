package com.igor.reservation_system.infrastructure.service;

import com.igor.reservation_system.core.entities.Hotel;
import com.igor.reservation_system.infrastructure.persistence.HotelEntity;
import com.igor.reservation_system.infrastructure.persistence.HotelReservationEntity;
import com.igor.reservation_system.infrastructure.persistence.repositories.HotelRepository;
import com.igor.reservation_system.infrastructure.persistence.repositories.HotelReservationRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelReservationScheduler {

    private HotelReservationRepository hotelReservationRepository;
    private HotelRepository hotelRepository;

    public HotelReservationScheduler(HotelReservationRepository hotelReservationRepository, HotelRepository hotelRepository) {
        this.hotelReservationRepository = hotelReservationRepository;
        this.hotelRepository = hotelRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateRoomAvailability() {
        LocalDate today = LocalDate.now();

        List<HotelReservationEntity> reservationsToCheckout = hotelReservationRepository
                .findByCheckOutDate(today);

        for (HotelReservationEntity reservation : reservationsToCheckout) {
            Long hotelId = reservation.getHotelId();
            int roomsToFree = reservation.getRoomsReserved();

            freeRooms(hotelId, roomsToFree);
        }
    }

    private void freeRooms(Long hotelId, int roomsToFree) {

        HotelEntity hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + hotelId));

        hotel.setTotalRooms(hotel.getTotalRooms() + roomsToFree);
        hotelRepository.save(hotel);
    }

}
