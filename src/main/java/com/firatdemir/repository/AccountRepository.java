package com.firatdemir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firatdemir.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
