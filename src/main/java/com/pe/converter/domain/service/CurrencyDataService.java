package com.pe.converter.domain.service;

import com.pe.converter.dto.CurrencyDataDto;

public interface CurrencyDataService {

	CurrencyDataDto calculateExchangeType(String currency, Double amount);

}
