package com.firatdemir.service.impl;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firatdemir.dto.DtoCar;
import com.firatdemir.dto.DtoCarIU;
import com.firatdemir.model.Car;
import com.firatdemir.repository.CarRepository;
import com.firatdemir.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {

	@Autowired
	private CarRepository carRepository;

	private Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		car.setCreatetime(new Date(0));
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}

	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
		DtoCar dtoCar = new DtoCar();
		Car savedCar = carRepository.save(createCar(dtoCarIU));

		BeanUtils.copyProperties(savedCar, dtoCar);
		return dtoCar;
	}

}
