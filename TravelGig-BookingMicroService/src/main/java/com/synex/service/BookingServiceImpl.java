package com.synex.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Booking;
import com.synex.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
    
    @Autowired BookingRepository bookingRepository;
    
    @Override
    public Booking save(Booking booking) {
        // Set<Guest> guestList = booking.getGuests();
        // System.out.println(guestList);
        
        Instant bookedTime = ZonedDateTime.now().toInstant().truncatedTo(ChronoUnit.DAYS);
        booking.setBookedOnDate(bookedTime.toString());
        
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
        List<Booking> myBookings = bookingRepository.findAllByUserName(userName);
        
        List<Integer> upcomingBookings = myBookings.stream()
                .filter(b -> b.getStatus().equals("UPCOMING"))  // Filter upcoming bookings to check if checkInDate is past current time.
                .map(b -> b.getBookingId())
                .collect(Collectors.toList());

        for (int id : upcomingBookings) {  // Change status of upcoming bookings if checkInDate is past current time.
            Booking booking = bookingRepository.findById(id).orElse(null);
            LocalDate checkInDate = LocalDate.of(Integer.parseInt(booking.getCheckInDate().substring(0, 4)),
                                                 Integer.parseInt(booking.getCheckInDate().substring(5, 7)),
                                                 Integer.parseInt(booking.getCheckInDate().substring(8)));
            // System.out.println("Upcoming Booking ID: " + id + ", CheckinDate: " + checkInDate);
            if (checkInDate.isBefore(LocalDate.now())) {
                booking.setStatus("COMPLETED");
                bookingRepository.save(booking);
            }
        }
        
        return bookingRepository.findAllByUserName(userName);
    }
    
}
