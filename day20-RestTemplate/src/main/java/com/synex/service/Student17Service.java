package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Student17;
import com.synex.repository.Student17Repository;

@Service
public class Student17Service {
    
    @Autowired Student17Repository student17Repository;
    
    public List<Student17> findAll() {
        return student17Repository.findAll();
    }
    
    public Student17 save(Student17 student) {
        return student17Repository.save(student);
    }
    
    public void deleteById(int studentId) {
        student17Repository.deleteById(studentId);
    }
    
    public List<Student17> findByTrainerListTrainerName(String trainerName) {
        return student17Repository.findByTrainerListTrainerName (trainerName);
    }
    
}
