package com.pe.converter.dto;

import lombok.Data;

@Data
public class CurrencyDataDto {
	private double amount;
	private String currency;
	private String date;
}
