package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Student;
import com.synex.domain.Trainer;
import com.synex.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired StudentRepository studentRepository;
    
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    
    public void deleteById(int studentId) {
        studentRepository.deleteById(studentId);
    }
    
    public List<Trainer> getTrainerList(int studentId) {
        return studentRepository.findById(studentId).orElse(null).getTrainerList();
    }
    
    public List<Student> findByTrainerListTrainerName(String trainerName) {
        return studentRepository.findByTrainerListName (trainerName);
    }
    
}
