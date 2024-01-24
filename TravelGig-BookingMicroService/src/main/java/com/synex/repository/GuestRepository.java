package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Guest;

// @Repository comes from JpaRepository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
