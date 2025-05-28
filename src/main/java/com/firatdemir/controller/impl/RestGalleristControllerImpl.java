package com.firatdemir.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firatdemir.controller.IRestGalleristController;
import com.firatdemir.controller.RestBaseController;
import com.firatdemir.controller.RootEntity;
import com.firatdemir.dto.DtoGallerist;
import com.firatdemir.dto.DtoGalleristIU;
import com.firatdemir.service.IGalleristService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController {

	@Autowired
	private IGalleristService galleristService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoGallerist> saveGalerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
		return ok(galleristService.saveGallerist(dtoGalleristIU));
	}

}
