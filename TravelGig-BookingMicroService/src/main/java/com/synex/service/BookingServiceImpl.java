package com.synex.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Booking;
import com.synex.domain.Guest;
import com.synex.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
    
    @Autowired BookingRepository bookingRepository;
    
    @Override
    public Booking save(Booking booking) {
        Set<Guest> guestList = booking.getGuests();
        System.out.println(guestList);
        
        return bookingRepository.save(booking);
    }
    
    @Override
    public Booking findById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }
    
    @Override
    public boolean existById(int id) {
        return bookingRepository.existsById(id);
    }

    @Override
    public List<Booking> findAllByUserName(String userName) {
        return bookingRepository.findAllByUserName(userName);
    }
    
}
