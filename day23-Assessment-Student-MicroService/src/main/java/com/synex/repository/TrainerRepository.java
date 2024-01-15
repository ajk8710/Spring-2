package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    public Trainer findByName(String trainerName);  // findByTrainerName
    
}
