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
