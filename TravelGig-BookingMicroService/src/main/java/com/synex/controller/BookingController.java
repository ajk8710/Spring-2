package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Booking;
import com.synex.service.BookingService;

@RestController
public class BookingController {
    
    @Autowired BookingService bookingService;
    
    @PostMapping("saveBooking")
    public Booking save(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }
    
    @GetMapping("findBookingById/{id}")
    public Booking findById(@PathVariable int id) {
        return bookingService.findById(id);
    }
    
    @GetMapping("existBookingById/{id}")
    boolean existById(@PathVariable int id) {
        return bookingService.existById(id);
    }
    
}

/* For postman test. Guest ID is not being sent, always 0. Just like I'm not sending booking id when saving booking.
{
    "hotelId": 1,
    "hotelRoomId": 1,
    "noRooms": 2,
    "guests": [
        {"Id": 52, "firstName": "f", "lastName": "l", "gender": "M", "age": 21},
        {"guestId": 53}
    ],
    "price": 2,
    "discount": 2,
    "roomType": 2
}
*/