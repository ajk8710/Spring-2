package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Student;
import com.synex.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired StudentRepository studentRepository;
    
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
    
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }
    
}
