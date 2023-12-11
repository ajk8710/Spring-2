package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.AddressD;

@Repository
public interface AddressRepository extends JpaRepository<AddressD, Integer> {

}
