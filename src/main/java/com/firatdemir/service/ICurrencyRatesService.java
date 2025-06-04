package com.firatdemir.service;

import com.firatdemir.dto.CurrenyRatesResponse;

public interface ICurrencyRatesService {

	public CurrenyRatesResponse getCurrencyRates(String startDate, String endDate);
}
