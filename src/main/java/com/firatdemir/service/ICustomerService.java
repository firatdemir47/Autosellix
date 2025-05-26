package com.firatdemir.service;

import com.firatdemir.dto.DtoCustomer;
import com.firatdemir.dto.DtoCustomerIU;

public interface ICustomerService {
	
	public DtoCustomer savecCustomer(DtoCustomerIU dtoCustomerIU);
}
