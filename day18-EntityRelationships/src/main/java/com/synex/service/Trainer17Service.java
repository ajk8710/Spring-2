package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Trainer17;
import com.synex.repository.Trainer17Repository;

@Service
public class Trainer17Service {
    
    @Autowired Trainer17Repository trainer17Repository;
    
    public Trainer17 findById(int trainerId) {
        return trainer17Repository.findById(trainerId).orElse(null);
    }
    
    public List<Trainer17> findAll() {
        return trainer17Repository.findAll();
    }
    
    public Trainer17 save(Trainer17 trainer) {
        return trainer17Repository.save(trainer);
    }
    
    public void deleteById(int trainerId) {
        trainer17Repository.deleteById(trainerId);
    }
    
    public List<Trainer17> findByStudentList_Name(String studentName) {
        return trainer17Repository.findByStudentList_Name(studentName);
    }
    
    public List<Trainer17> findByStudentListName(String studentName) {
        return trainer17Repository.findByStudentListName(studentName);
    }
    
}
