package com.firatdemir.dto;

import java.math.BigDecimal;

import com.firatdemir.enums.CurrencyType;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAccountIU {

	@NotNull
	private String accountNo;

	@NotNull
	private String iban;

	@NotNull
	private BigDecimal amount;
	
	@NotNull
	private CurrencyType currencyType;
}
