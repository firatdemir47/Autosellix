package com.firatdemir.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firatdemir.controller.IRestAddressController;
import com.firatdemir.controller.RestBaseController;
import com.firatdemir.controller.RootEntity;
import com.firatdemir.dto.DtoAddreessIU;
import com.firatdemir.dto.DtoAddress;
import com.firatdemir.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

	@Autowired
	private IAddressService addressService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddreessIU dtoAddreessIU) {
		// TODO Auto-generated method stub
		return ok(addressService.saveAddress(dtoAddreessIU));
	}

}
