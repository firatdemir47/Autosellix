package com.firatdemir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firatdemir.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
