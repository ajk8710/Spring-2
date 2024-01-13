package com.synex.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Hotel;
import com.synex.domain.RoomType;
import com.synex.service.HotelService;

@RestController
public class HotelController {
    
    @Autowired HotelService hotelService;
    
    @GetMapping("searchHotel/{searchString}")
    public List<Hotel> searchHotel(@PathVariable String searchString) {
        return hotelService.searchHotel(searchString);
    }
    
    @GetMapping("getRoomTypesOfHotel/{hotelId}")
    public Set<RoomType> getRoomTypesOfHotel(@PathVariable int hotelId) {
        return hotelService.getRoomTypesOfHotel(hotelId);
    }
    
}
