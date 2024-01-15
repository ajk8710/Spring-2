package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Student;
import com.synex.domain.Trainer;
import com.synex.repository.TrainerRepository;

@Service
public class TrainerService {
    
    @Autowired TrainerRepository trainerRepository;
    
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }
    
    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    
    public void deleteById(int trainerId) {
        trainerRepository.deleteById(trainerId);
    }
    
    public List<Student> getStudentList(String trainerName) {
        return trainerRepository.findByName(trainerName).getStudentList();
    }
    
}
