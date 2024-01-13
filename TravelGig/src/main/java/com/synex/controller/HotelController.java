package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.client.HotelClient;

@RestController
public class HotelController {
    
    @Autowired HotelClient hotelClient;
    
    @GetMapping("searchHotel/{searchString}")
    public JsonNode searchHotel(@PathVariable String searchString) {
        return hotelClient.searchHotel(searchString);
    }
    
    @GetMapping("getRoomTypesOfHotel/{hotelId}")
    public JsonNode getRoomTypesOfHotel(@PathVariable int hotelId) {
        return hotelClient.getRoomTypesOfHotel(hotelId);
    }
    
}
