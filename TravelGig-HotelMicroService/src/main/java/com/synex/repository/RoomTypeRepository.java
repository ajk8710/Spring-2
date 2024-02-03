package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.RoomType;

// @Repository comes from JpaRepository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    
}
