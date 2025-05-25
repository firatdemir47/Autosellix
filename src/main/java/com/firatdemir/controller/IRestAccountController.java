package com.firatdemir.controller;

import com.firatdemir.dto.DtoAccount;
import com.firatdemir.dto.DtoAccountIU;

public interface IRestAccountController {

	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
