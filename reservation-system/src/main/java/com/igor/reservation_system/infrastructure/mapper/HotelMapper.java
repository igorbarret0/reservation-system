package com.igor.reservation_system.infrastructure.mapper;

import com.igor.reservation_system.core.entities.Hotel;
import com.igor.reservation_system.infrastructure.dtos.HotelRequest;
import com.igor.reservation_system.infrastructure.dtos.HotelResponse;
import com.igor.reservation_system.infrastructure.persistence.HotelEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel toHotelFromHotelEntity(HotelEntity entity) {

        return new Hotel(
                null,
                entity.getName(),
                entity.getLocation(),
                entity.getTotalRooms(),
                entity.getPricePerNight(),
                entity.getAmenities()
        );
    }

    public HotelEntity toHotelEntityFromHotel(Hotel hotel) {


        return new HotelEntity(
                null,
                hotel.name(),
                hotel.location(),
                hotel.totalRooms(),
                hotel.pricePerNight(),
                hotel.amenities()
        );
    }

    public Hotel toHotelFromHotelRequest(HotelRequest request) {

        return  new Hotel(
                null,
                request.name(),
                request.location(),
                request.totalRooms(),
                request.pricePerNight(),
                request.amenities()
        );
    }

    public HotelResponse toHotelResponseFromHotel(Hotel hotel) {

        return new HotelResponse(
                hotel.name(),
                hotel.location(),
                hotel.totalRooms(),
                hotel.pricePerNight(),
                hotel.amenities()
        );
    }

}
