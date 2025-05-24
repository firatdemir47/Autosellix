package com.firatdemir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firatdemir.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{ 

}
