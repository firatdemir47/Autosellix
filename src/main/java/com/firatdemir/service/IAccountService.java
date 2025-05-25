package com.firatdemir.service;

import com.firatdemir.dto.DtoAccount;
import com.firatdemir.dto.DtoAccountIU;

public interface IAccountService {
	
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
