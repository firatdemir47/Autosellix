package com.firatdemir.service.impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firatdemir.dto.DtoAddress;
import com.firatdemir.dto.DtoGallerist;
import com.firatdemir.dto.DtoGalleristIU;
import com.firatdemir.exception.BaseException;
import com.firatdemir.exception.ErrorMessage;
import com.firatdemir.exception.MessageType;
import com.firatdemir.model.Address;
import com.firatdemir.model.Gallerist;
import com.firatdemir.repository.AddressRepository;
import com.firatdemir.repository.GalleristRepository;
import com.firatdemir.service.IGalleristService;

@Service
public class GalleristServiceImpl implements IGalleristService {

	@Autowired
	private GalleristRepository galleristRepository;

	@Autowired
	private AddressRepository addressRepository;

	private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {

		Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressID());
		if (optAddress.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressID().toString()));
		}

		Gallerist gallerist = new Gallerist();
		gallerist.setCreatetime(new Date(0));
		BeanUtils.copyProperties(dtoGalleristIU, gallerist);
		gallerist.setAddress(optAddress.get());
		return gallerist;
	}

	@Override
	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {

		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoAddress dtoAddress = new DtoAddress();

		Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

		BeanUtils.copyProperties(savedGallerist, dtoGallerist);
		BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

		dtoGallerist.setDtoAddress(dtoAddress);

		return dtoGallerist;
	}

}
