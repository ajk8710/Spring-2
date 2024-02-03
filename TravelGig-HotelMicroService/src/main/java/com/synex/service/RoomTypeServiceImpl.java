package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.RoomType;
import com.synex.repository.RoomTypeRepository;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    
    @Autowired RoomTypeRepository roomTypeRepository;
    
    @Override
    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType findById(int id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        roomTypeRepository.deleteById(id);
        
    }
    
    @Override
    public boolean existById(int id) {
        return roomTypeRepository.existsById(id);
    }
    
}
