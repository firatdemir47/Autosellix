package com.firatdemir.service.impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firatdemir.dto.DtoAddress;
import com.firatdemir.dto.DtoCar;
import com.firatdemir.dto.DtoGallerist;
import com.firatdemir.dto.DtoGalleristCar;
import com.firatdemir.dto.DtoGalleristCarIU;
import com.firatdemir.dto.DtoGalleristIU;
import com.firatdemir.exception.BaseException;
import com.firatdemir.exception.ErrorMessage;
import com.firatdemir.exception.MessageType;
import com.firatdemir.model.Car;
import com.firatdemir.model.Gallerist;
import com.firatdemir.model.GalleristCar;
import com.firatdemir.repository.CarRepository;
import com.firatdemir.repository.GalleristCarRepository;
import com.firatdemir.repository.GalleristRepository;
import com.firatdemir.service.IGalleristCarService;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {

	@Autowired
	private GalleristCarRepository galleristCarRepository;

	@Autowired
	private GalleristRepository galleristRepository;

	@Autowired
	private CarRepository carRepository;

	private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
		if (optGallerist.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getGalleristId().toString()));
		}

		Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
		if (optCar.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getCarId().toString()));

		}
		GalleristCar galleristCar = new GalleristCar();
		galleristCar.setCreatetime(new Date(0));
		galleristCar.setGallerist(optGallerist.get());
		galleristCar.setCar(optCar.get());

		return galleristCar;
	}

	@Override
	public DtoGalleristCar saveGalleristCa(DtoGalleristCarIU dtoGalleristCarIU) {
		DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCar dtoCar = new DtoCar();

		DtoAddress dtoAddress = new DtoAddress();

		GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
		BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
		BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
		BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);

		dtoGallerist.setDtoAddress(dtoAddress);
		dtoGalleristCar.setGallerist(dtoGallerist);

		dtoGalleristCar.setCar(dtoCar);
		return dtoGalleristCar;
	}

}
