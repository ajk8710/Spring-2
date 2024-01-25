package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.client.BookingClient;

@RestController
public class BookingController {
    
    @Autowired BookingClient bookingClient;
    
    @PostMapping("saveBooking")
    public JsonNode saveBooking(@RequestBody JsonNode json) {
        return bookingClient.saveBooking(json);
    }
    
}
