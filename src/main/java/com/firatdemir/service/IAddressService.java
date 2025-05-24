package com.firatdemir.service;

import com.firatdemir.dto.DtoAddreessIU;
import com.firatdemir.dto.DtoAddress;

public interface IAddressService {
	
	public DtoAddress saveAddress(DtoAddreessIU dtoAddreessIU);
}
