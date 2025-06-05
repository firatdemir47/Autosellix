package com.firatdemir.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firatdemir.controller.IRestCurrencyRatesController;
import com.firatdemir.controller.RestBaseController;
import com.firatdemir.controller.RootEntity;
import com.firatdemir.dto.CurrenyRatesResponse;
import com.firatdemir.service.ICurrencyRatesService;

@RestController
@RequestMapping("/rest/api/currency-rates")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController {

	@Autowired
	private ICurrencyRatesService currencyRatesService;

	@GetMapping("/")
	@Override
	public RootEntity<CurrenyRatesResponse> getCurrencyRates(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
	}

}
