package com.igor.reservation_system.infrastructure.persistence;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    Integer totalRooms;

    BigDecimal pricePerNight;

    String amenities;

    public HotelEntity() {}

    public HotelEntity(Long id, String name, String location, Integer totalRooms, BigDecimal pricePerNight, String amenities) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.totalRooms = totalRooms;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}
