package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class DummyHotelDao implements HotelDao {
    private List<Hotel> hotels = new ArrayList<>();

    public DummyHotelDao() {
        Address address = new Address("Dummy Street", "Dummy Street", "Dummy City", "Dummy State", "Dummy Zip");
        Hotel hotel1 = new Hotel(1, "Dummy 1", address, 4, 20, 200.00);
        Hotel hotel2 = new Hotel(2, "Dummy 2", address, 2, 100, 50.00);
        hotels.add(hotel1);
        hotels.add(hotel2);
    }

    @Override
    public List<Hotel> list() {
        return hotels;
    }

    @Override
    public void create(Hotel hotel) {

    }

    @Override
    public Hotel get(int id) {
        return hotels.get(0);
    }
}