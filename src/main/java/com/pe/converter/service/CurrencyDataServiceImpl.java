package com.pe.converter.service;

import javax.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.pe.converter.domain.model.CurrencyData;
import com.pe.converter.domain.service.CurrencyDataService;
import com.pe.converter.dto.CurrencyDataDto;

@Service
public class CurrencyDataServiceImpl implements CurrencyDataService {

	private final RestTemplate restTemplate;

	private static final String usd = "USD";
	private static final String pen = "PEN";
	private static final String error1 = "Not type of currency registered, try again";
	private static final String error2 = "Amount must be over 0";

	@Value("${urlApi}")
	private String urlApi;

	@Autowired
	public CurrencyDataServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public CurrencyDataDto calculateExchangeType(String currency, Double amount) {
		CurrencyData currencyData = restTemplate.getForObject(urlApi, CurrencyData.class);
		CurrencyDataDto currencyDataDto = new CurrencyDataDto();	
		if (!(currency.equals(usd) || currency.equals(pen))) {
			throw new ValidationException(error1);
		}
		
		
		
		
		if (amount < 0) {
			throw new ValidationException(error2);
		}

		if (currency.equals(usd)) {
			amount = amount * currencyData.getCompra();
			currencyData.setMoneda(pen);
		} else if (currency.equals(pen)) {
			amount = amount / currencyData.getVenta();
			currencyData.setMoneda(usd);
		}
		currencyDataDto.setAmount(amount);
		currencyDataDto.setCurrency(currencyData.getMoneda());
		currencyDataDto.setDate(currencyData.getFecha());

		return currencyDataDto;
	}
}
