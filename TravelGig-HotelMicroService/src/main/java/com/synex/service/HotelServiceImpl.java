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
public class HotelServiceImpl implements HotelService {
    
    @Autowired HotelRepository hotelRepository;
    
    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel findById(int id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existById(int id) {
        return hotelRepository.existsById(id);
    }
    
    @Override
    public List<Hotel> searchHotel(String searchString) {
        searchString = "%" + searchString + "%";  // wrapping with % means contains
        return hotelRepository.findByHotelNameLikeIgnoreCaseOrAddressLikeIgnoreCaseOrCityLikeIgnoreCaseOrStateLikeIgnoreCase(searchString, searchString, searchString, searchString);
    }
    
    @Override
    public Set<RoomType> getRoomTypesOfHotel(int hotelId) {
        Set<RoomType> roomTypesOfHotel = new HashSet<>();
        
        Set<HotelRoom> hotelRooms = hotelRepository.findById(hotelId).orElse(null).getHotelRooms();  // may need to handle null pointer exception
        for (HotelRoom room : hotelRooms) {
            roomTypesOfHotel.add(room.getType());
        }
        return roomTypesOfHotel;
    }
    
    @Override
    public List<Float> getRoomPriceAndDiscount(int hotelId, int roomTypeId) {
        // ArrayList representing: index 0: room price, index 1: room discount, index 2: room id.
        List<Float> priceDiscountRoomId = new ArrayList<>();
        
        // From set of hotelRooms of hotel given hotelId, find matching room type.
        Set<HotelRoom> hotelRooms = hotelRepository.findById(hotelId).orElse(null).getHotelRooms();  // may need to handle null pointer exception
        for (HotelRoom room : hotelRooms) {
            if (room.getType().getTypeId() == roomTypeId) {  // Once matching room type found, get its price, discount and room id.
                priceDiscountRoomId.add(room.getPrice());    // Room id represents rooms of same type and price. A room entity contains number of rooms.
                priceDiscountRoomId.add(room.getDiscount());
                priceDiscountRoomId.add((float) room.getHotelRoomId());
                break;  // Once found, break out of loop.
            }
        }
        return priceDiscountRoomId;
    }
    
}
