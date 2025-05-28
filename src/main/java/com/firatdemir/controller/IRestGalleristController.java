package com.firatdemir.controller;

import com.firatdemir.dto.DtoGallerist;
import com.firatdemir.dto.DtoGalleristIU;

public interface IRestGalleristController {

	public RootEntity<DtoGallerist> saveGalerist(DtoGalleristIU dtoGalleristIU);
}
