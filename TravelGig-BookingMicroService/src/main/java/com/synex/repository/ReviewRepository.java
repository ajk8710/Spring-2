package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Review;

// @Repository comes from JpaRepository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}
