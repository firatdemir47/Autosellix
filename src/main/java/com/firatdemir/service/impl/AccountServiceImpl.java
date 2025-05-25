package com.firatdemir.service.impl;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firatdemir.dto.DtoAccount;
import com.firatdemir.dto.DtoAccountIU;
import com.firatdemir.model.Account;
import com.firatdemir.repository.AccountRepository;
import com.firatdemir.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	private Account createAccount(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		account.setCreatetime(new Date(0));

		BeanUtils.copyProperties(dtoAccountIU, account);
		return account;
	}

	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
		DtoAccount dtoAccount = new DtoAccount();
		Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	}

}
