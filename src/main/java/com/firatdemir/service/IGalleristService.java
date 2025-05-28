package com.firatdemir.service;

import com.firatdemir.dto.DtoGallerist;
import com.firatdemir.dto.DtoGalleristIU;

public interface IGalleristService {

	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
