package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.Student17;

@Repository
public interface Student17Repository extends JpaRepository<Student17, Integer> {
    
    // Using nomenclature
    // findBy (from Trainers) NameOfAttribute NameOfAttribute
    public List<Student17> findByTrainerListTrainerName(String trainerName);
    
}
