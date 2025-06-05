package com.firatdemir.controller;

import com.firatdemir.dto.CurrenyRatesResponse;

public interface IRestCurrencyRatesController {

	public RootEntity<CurrenyRatesResponse> getCurrencyRates(String startDate, String endDate);
}
