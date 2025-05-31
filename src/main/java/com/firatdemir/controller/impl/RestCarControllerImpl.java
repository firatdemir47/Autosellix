package com.firatdemir.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firatdemir.controller.IRestCarController;
import com.firatdemir.controller.RestBaseController;
import com.firatdemir.controller.RootEntity;
import com.firatdemir.dto.DtoCar;
import com.firatdemir.dto.DtoCarIU;
import com.firatdemir.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

	@Autowired
	private ICarService carService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {

		return ok(carService.saveCar(dtoCarIU));
	}

}
