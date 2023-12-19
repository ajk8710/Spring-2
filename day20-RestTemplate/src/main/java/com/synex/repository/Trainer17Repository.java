package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.Trainer17;

@Repository
public interface Trainer17Repository extends JpaRepository<Trainer17, Integer> {
    
    // Using nomenclature
    // findBy (from Trainers) NameOfAttribute _NameOfAttribute
    public List<Trainer17> findByStudentList_Name(String studentName);
    
    // findBy (from Trainers) NameOfAttribute NameOfAttribute
    public List<Trainer17> findByStudentListName(String studentName);
    
}
