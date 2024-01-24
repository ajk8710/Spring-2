package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Booking;
import com.synex.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
    
    @Autowired BookingRepository bookingRepository;
    
    @Override
    public Booking save(Booking booking) {
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
    
}
