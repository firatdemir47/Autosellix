package com.firatdemir.controller;

import com.firatdemir.dto.DtoCar;
import com.firatdemir.dto.DtoCarIU;

public interface IRestCarController {
	
	public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
