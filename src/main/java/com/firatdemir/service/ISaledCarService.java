package com.firatdemir.service;

import com.firatdemir.dto.DtoSaledCar;
import com.firatdemir.dto.DtoSaledCarIU;

public interface ISaledCarService {

	public DtoSaledCar BuyCar(DtoSaledCarIU dtoSaledCarIU);
}
