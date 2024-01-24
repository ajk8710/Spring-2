package com.synex.service;

import com.synex.domain.Booking;

public interface BookingService {
        
    public Booking save(Booking booking);
    public Booking findById(int id);
    boolean existById(int id);
    
}
