package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.Hotel;

// @Repository comes from JpaRepository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    
    // find exact match
    public List<Hotel> findByHotelNameOrAddressOrCityOrState(String hotelName, String address, String city, String state);
    
    // find like match
    public List<Hotel> findByHotelNameLikeOrAddressLikeOrCityLikeOrStateLike(String hotelName, String address, String city, String state);
    
    // find like match, ignore case
    public List<Hotel> findByHotelNameLikeIgnoreCaseOrAddressLikeIgnoreCaseOrCityLikeIgnoreCaseOrStateLikeIgnoreCase(String hotelName, String address, String city, String state);
}
