package com.synex.service;

import java.util.List;

import com.synex.domain.RoomType;

public interface RoomTypeService {
    
    RoomType save(RoomType roomType);
    RoomType findById(int id);
    List<RoomType> findAll();
    void deleteById(int id);
    boolean existById(int id);
    
}
