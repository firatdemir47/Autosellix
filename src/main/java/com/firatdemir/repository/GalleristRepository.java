package com.firatdemir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firatdemir.model.Gallerist;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long> {
	
	
}
