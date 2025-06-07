package com.firatdemir.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firatdemir.dto.CurrenyRatesResponse;
import com.firatdemir.dto.DtoCar;
import com.firatdemir.dto.DtoCustomer;
import com.firatdemir.dto.DtoGallerist;
import com.firatdemir.dto.DtoSaledCar;
import com.firatdemir.dto.DtoSaledCarIU;
import com.firatdemir.enums.CarStatusType;
import com.firatdemir.exception.BaseException;
import com.firatdemir.exception.ErrorMessage;
import com.firatdemir.exception.MessageType;
import com.firatdemir.model.Car;
import com.firatdemir.model.Customer;
import com.firatdemir.model.SaledCar;
import com.firatdemir.repository.CarRepository;
import com.firatdemir.repository.CustomerRepository;
import com.firatdemir.repository.GalleristRepository;
import com.firatdemir.repository.SaledCarRepository;
import com.firatdemir.service.ICurrencyRatesService;
import com.firatdemir.service.ISaledCarService;
import com.firatdemir.utils.DateUtils;

@Service
public class SaledCarServiceImpl implements ISaledCarService {

	@Autowired
	private SaledCarRepository saledCarRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private GalleristRepository galleristRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ICurrencyRatesService currencyRatesService;

	public BigDecimal convertCustomerAmountToUSD(Customer customer) {

		CurrenyRatesResponse currenyRatesResponse = currencyRatesService
				.getCurrencyRates(DateUtils.getcurrentDate(new Date(0)), DateUtils.getcurrentDate(new Date(0)));
		BigDecimal usd = new BigDecimal(currenyRatesResponse.getItems().get(0).getUsd());
		BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);
		return customerUSDAmount;
	}

	public boolean checkCarStatus(Long carId) {

		Optional<Car> optCar = carRepository.findById(carId);
		if (optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
			return false;
		}
		return true;
	}

	public BigDecimal remaningCustomerAmount(Customer customer, Car car) {
		BigDecimal customerUSDAmount = convertCustomerAmountToUSD(customer);
		BigDecimal remaningCustomerUSDAmount = customerUSDAmount.subtract(car.getPrice());

		CurrenyRatesResponse currenyRatesResponse = currencyRatesService
				.getCurrencyRates(DateUtils.getcurrentDate(new Date(0)), DateUtils.getcurrentDate(new Date(0)));
		BigDecimal usd = new BigDecimal(currenyRatesResponse.getItems().get(0).getUsd());
		return remaningCustomerUSDAmount.multiply(usd);
	}

	public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {
		Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
		if (optCustomer.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCustomerId().toString()));
		}
		Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
		if (optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
		}
		BigDecimal customerUSDAmount = convertCustomerAmountToUSD(optCustomer.get());
		if (customerUSDAmount.compareTo(optCar.get().getPrice()) == 0
				|| customerUSDAmount.compareTo(optCar.get().getPrice()) > 0) {
			return true;
		}
		return false;
	}

	private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {
		SaledCar saledCar = new SaledCar();
		saledCar.setCreatetime(new Date(0));

		saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
		saledCar.setGallerist(galleristRepository.findById(dtoSaledCarIU.getGalleristId()).orElse(null));
		saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));
		return saledCar;

	}

	@Override
	public DtoSaledCar BuyCar(DtoSaledCarIU dtoSaledCarIU) {
		if (!checkAmount(dtoSaledCarIU)) {
			throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH, ""));
		}
		if (!checkCarStatus(dtoSaledCarIU.getCarId())) {
			throw new BaseException(
					new ErrorMessage(MessageType.CAR_STATUS_IS_ALREADY_SALED, dtoSaledCarIU.toString()));

		}
		SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));

		Car car = savedSaledCar.getCar();
		car.setCarStatusType(CarStatusType.SALED);

		carRepository.save(car);

		Customer customer = savedSaledCar.getCustomer();
		customer.getAccount().setAmount(remaningCustomerAmount(customer, car));
		customerRepository.save(customer);
		return toDTO(savedSaledCar);
	}

	public DtoSaledCar toDTO(SaledCar saledCar) {
		DtoSaledCar dtoSaledCar = new DtoSaledCar();
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCar dtoCar = new DtoCar();

		BeanUtils.copyProperties(saledCar, dtoSaledCar);
		BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(saledCar.getCar(), dtoCar);

		dtoSaledCar.setCustomer(dtoCustomer);
		dtoSaledCar.setGallerist(dtoGallerist);
		dtoSaledCar.setCar(dtoCar);

		return dtoSaledCar;

	}

}
