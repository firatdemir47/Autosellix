package com.firatdemir.service.impl;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firatdemir.dto.DtoAddreessIU;
import com.firatdemir.dto.DtoAddress;
import com.firatdemir.model.Address;
import com.firatdemir.repository.AddressRepository;
import com.firatdemir.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	private Address createAddress(DtoAddreessIU dtoAddreessIU) {

		Address address = new Address();
		address.setCreatetime(new Date(0));
		BeanUtils.copyProperties(dtoAddreessIU, address);
		return address;
	}

	@Override
	public DtoAddress saveAddress(DtoAddreessIU dtoAddreessIU) {
		DtoAddress dtoAddress = new DtoAddress();
		Address savedAddress = addressRepository.save(createAddress(dtoAddreessIU));
		BeanUtils.copyProperties(savedAddress, dtoAddress);
		return dtoAddress;
	}

}
