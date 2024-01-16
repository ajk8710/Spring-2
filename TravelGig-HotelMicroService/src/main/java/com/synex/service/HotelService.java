package com.synex.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Hotel;
import com.synex.domain.HotelRoom;
import com.synex.domain.RoomType;
import com.synex.repository.HotelRepository;

@Service
public class HotelService {
    
    @Autowired HotelRepository hotelRepository;
    
    public List<Hotel> searchHotel(String searchString) {
        searchString = "%" + searchString + "%";  // wrapping with % means contains
        return hotelRepository.findByHotelNameLikeIgnoreCaseOrAddressLikeIgnoreCaseOrCityLikeIgnoreCaseOrStateLikeIgnoreCase(searchString, searchString, searchString, searchString);
    }
    
    public Set<RoomType> getRoomTypesOfHotel(int hotelId) {
        Set<RoomType> roomTypesOfHotel = new HashSet<>();
        
        Set<HotelRoom> hotelRooms = hotelRepository.findById(hotelId).orElse(null).getHotelRooms();  // may need to handle null pointer exception
        for (HotelRoom room : hotelRooms) {
            roomTypesOfHotel.add(room.getType());
        }
        return roomTypesOfHotel;
    }
    
    public List<Float> getRoomPriceAndDiscount(int hotelId, int roomTypeId) {
        List<Float> hotelIdAndRoomTypeId = new ArrayList<>();
        
        Set<HotelRoom> hotelRooms = hotelRepository.findById(hotelId).orElse(null).getHotelRooms();  // may need to handle null pointer exception
        for (HotelRoom room : hotelRooms) {
            if (room.getType().getTypeId() == roomTypeId) {
                hotelIdAndRoomTypeId.add(room.getPrice());
                hotelIdAndRoomTypeId.add(room.getDiscount());
                break;
            }
        }
        return hotelIdAndRoomTypeId;
    }
    
}
