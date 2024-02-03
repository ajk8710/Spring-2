package com.synex.service;

import java.util.List;

import com.synex.domain.Booking;

public interface BookingService {
        
    public Booking save(Booking booking);
    public Booking findById(int id);
    public boolean existById(int id);
    
    public List<Booking> findAllByUserName(String userName);
    
}
