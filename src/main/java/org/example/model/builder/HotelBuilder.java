package org.example.model.builder;

import org.example.model.Hotel;

public class HotelBuilder {

    private Hotel hotel;

    public HotelBuilder() {
        hotel = new Hotel();
    }

    public HotelBuilder setId(int id) {
        this.hotel.setId(id);
        return this;
    }
    public HotelBuilder setName(String name) {
        this.hotel.setName(name);
        return this;
    }

    public HotelBuilder setStreet(String street) {
        this.hotel.setStreet(street);
        return this;
    }

    public HotelBuilder setPool(boolean pool) {
        this.hotel.setPool(pool);
        return this;
    }

    public HotelBuilder setRestaurant(boolean restaurant) {
        this.hotel.setRestaurant(restaurant);
        return this;
    }

    public HotelBuilder setRating(int rating) {
        this.hotel.setRating(rating);
        return this;
    }

    public HotelBuilder setCity(String city) {
        this.hotel.setCity(city);
        return this;
    }

    public Hotel getHotel() {
        return this.hotel;
    }
}
