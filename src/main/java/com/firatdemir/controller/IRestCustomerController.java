package com.firatdemir.controller;

import com.firatdemir.dto.DtoCustomer;
import com.firatdemir.dto.DtoCustomerIU;

public interface IRestCustomerController {

	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
