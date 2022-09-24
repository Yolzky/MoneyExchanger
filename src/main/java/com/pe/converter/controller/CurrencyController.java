package com.pe.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pe.converter.domain.service.CurrencyDataService;
import com.pe.converter.dto.CurrencyDataDto;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/change")
public class CurrencyController {

	@Autowired
	private CurrencyDataService currencyDataService;
	
	@GetMapping("/{currency}/{amount}")
	@ApiResponses(value = {	@ApiResponse(responseCode = "200", description = "Money Converted", content = @Content(mediaType = "application/json"))})
	public CurrencyDataDto convertMoney(@PathVariable String currency, @PathVariable Double amount) {
		//return currencyDataService.calculateExchangeType(currency, amount);
		return currencyDataService.calculateExchangeType(currency, amount);
	}

}
