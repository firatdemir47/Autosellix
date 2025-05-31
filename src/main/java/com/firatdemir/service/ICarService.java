package com.firatdemir.service;

import com.firatdemir.dto.DtoCar;
import com.firatdemir.dto.DtoCarIU;

public interface ICarService {
	
	public DtoCar saveCar(DtoCarIU dtoCarIU);
}
