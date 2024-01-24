package com.synex.service;

import java.util.List;
import java.util.Set;

import com.synex.domain.Hotel;
import com.synex.domain.RoomType;

public interface HotelService {
    
    List<Hotel> searchHotel(String searchString);
    Set<RoomType> getRoomTypesOfHotel(int hotelId);
    List<Float> getRoomPriceAndDiscount(int hotelId, int roomTypeId);
    
}
