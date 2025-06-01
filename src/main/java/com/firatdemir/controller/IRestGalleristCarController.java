package com.firatdemir.controller;

import com.firatdemir.dto.DtoGalleristCar;
import com.firatdemir.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {
	
	public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
