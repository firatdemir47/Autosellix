package com.firatdemir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firatdemir.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{ 

}
