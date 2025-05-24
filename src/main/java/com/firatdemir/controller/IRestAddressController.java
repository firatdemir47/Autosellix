package com.firatdemir.controller;

import com.firatdemir.dto.DtoAddreessIU;
import com.firatdemir.dto.DtoAddress;

public interface IRestAddressController {
	public RootEntity< DtoAddress> saveAddress(DtoAddreessIU dtoAddreessIU);
}
