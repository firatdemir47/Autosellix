package com.firatdemir.dto;

import java.math.BigDecimal;

import com.firatdemir.enums.CarStatusType;
import com.firatdemir.enums.CurrencyType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCarIU {

	private String plaka;

	private String brand;

	private String model;

	private Integer productionYear;

	private BigDecimal price;

	private CurrencyType currencyType;

	private BigDecimal damagePrice;

	private CarStatusType carStatusType;

}
