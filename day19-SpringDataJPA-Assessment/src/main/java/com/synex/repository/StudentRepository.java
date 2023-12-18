package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    // Using method name nomenclature
    public Student findByName(String name);
}
