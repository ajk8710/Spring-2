package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    // Using nomenclature
    // findBy NameOfAttribute NameOfAttribute
    // It's like findBy.trainerList.trainerName (If student's trainerList contains trainer with trainer name, get me these students)
    // i.e. find students, who has trainer name in its trainerList.
    public List<Student> findByTrainerListName(String trainerName);  // findByTrainerListTrainerName
    
    // More intuitive and efficient way would be calling from TrainerService.
    // trainerRepository.findById(trainerId).orElse(null).getStudentList();
    // trainerRepository.findByName(trainerName).getStudentList();
    
}
