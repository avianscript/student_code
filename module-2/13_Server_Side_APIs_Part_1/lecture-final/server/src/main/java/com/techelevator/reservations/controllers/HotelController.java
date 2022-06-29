package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/hotels") -- if this is uncommented EVERY endpoint defined will be preceeded by /hotels
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable Integer id) {
        return hotelDao.get(id);
    }


    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
//    public List<Reservation> listReservations(@RequestParam(required = false) Integer maxGuests) {

    public List<Reservation> listReservations(@RequestParam(defaultValue = "0") Integer maxGuests) {
        List<Reservation> reservationList = reservationDao.findAll();
        List<Reservation> result = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if ( maxGuests == 0 || reservation.getGuests() <= maxGuests) {
                result.add(reservation);
            }
        }
        return result;
    }

    @RequestMapping(path = "/hotels/filter")
    public List<Hotel> filterHotelsByStateOrCity(@RequestParam String state, @RequestParam(required = false) String city) {

        List<Hotel> hotelList = hotelDao.list();

        List<Hotel> result = new ArrayList<>();

        for (Hotel hotel : hotelList) {
            String hotelState = hotel.getAddress().getState();
            String hotelCity = hotel.getAddress().getCity();

            if (city == null && hotelState.equalsIgnoreCase(state)) {
                result.add(hotel);
            } else if (city != null && hotelCity.equalsIgnoreCase(city)) {
                result.add(hotel);
            }
        }

        return result;

    }

//    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
//    public Reservation getReservation(@PathVariable("id") Integer reservationId) {
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable Integer id) {
        Reservation reservation = reservationDao.get(id);
        return reservation;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation newReservation) {
        Reservation savedReservation = reservationDao.create(newReservation, newReservation.getHotelID());
        return savedReservation;
    }

    // /hotels/3/reservations
    @RequestMapping(path = "/hotels/{hotelId}/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservationsForHotel(@PathVariable Integer hotelId) {
        return reservationDao.findByHotel(hotelId);
    }

}
