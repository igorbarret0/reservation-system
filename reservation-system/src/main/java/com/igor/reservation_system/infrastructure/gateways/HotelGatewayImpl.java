package com.igor.reservation_system.infrastructure.gateways;

import com.igor.reservation_system.core.entities.Hotel;
import com.igor.reservation_system.core.gateways.HotelGateway;
import com.igor.reservation_system.infrastructure.mapper.HotelMapper;
import com.igor.reservation_system.infrastructure.persistence.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelGatewayImpl implements HotelGateway {

    private HotelRepository hotelRepository;
    private HotelMapper mapper;

    public HotelGatewayImpl(HotelRepository hotelRepository, HotelMapper mapper) {
        this.hotelRepository = hotelRepository;
        this.mapper = mapper;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {

        var hotelEntity = hotelRepository.save(mapper.toHotelEntityFromHotel(hotel));
        return mapper.toHotelFromHotelEntity(hotelEntity);
    }

    @Override
    public List<Hotel> getAllHotels() {

        return hotelRepository.findAll()
                .stream().map(
                        hotel -> mapper.toHotelFromHotelEntity(hotel)
                ).toList();
    }

    @Override
    public Hotel getHotelById(Long id) {

        var hotelFound = hotelRepository.findById(id);
        return hotelFound.map(hotelEntity -> mapper.toHotelFromHotelEntity(hotelEntity)).orElse(null);
    }

    @Override
    public List<Hotel> getHotelsByLocation(String location) {

        return hotelRepository.findAllHotelsByLocation(location)
                .stream().map(
                        hotel -> mapper.toHotelFromHotelEntity(hotel)
                ).toList();
    }

    @Override
    public boolean existsHotelByName(String name) {

        return hotelRepository.existsByName(name);
    }

    @Override
    public void updateAvailableRooms(Long hotelId, int roomsReserved) {

        var hotelFound = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotelFound.setTotalRooms(hotelFound.getTotalRooms() - roomsReserved);
        hotelRepository.save(hotelFound);

    }
}
