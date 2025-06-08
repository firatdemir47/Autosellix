package com.firatdemir.controller;

import com.firatdemir.dto.DtoSaledCar;
import com.firatdemir.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

	public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
