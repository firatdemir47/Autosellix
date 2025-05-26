package com.firatdemir.controller;

import com.firatdemir.dto.DtoCustomer;
import com.firatdemir.dto.DtoCustomerIU;

public interface IRestCustomerController {

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
