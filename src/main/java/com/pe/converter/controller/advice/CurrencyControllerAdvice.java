package com.pe.converter.controller.advice;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pe.converter.dto.ErrorDto;

@RestControllerAdvice
public class CurrencyControllerAdvice {

	private static final String errorExpectationFailed = "412";

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<ErrorDto> runtimeExceptionHandler(ValidationException ex) {
		ErrorDto error = ErrorDto.builder().code(errorExpectationFailed).message(ex.getMessage()).build();
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}

}
