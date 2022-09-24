package com.pe.converter.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyData {
	
	private Double compra;
	
	private Double venta;
	
	private String origen;
	
	private String moneda;
	
	private String fecha;
}
