package com.tax.demo.dtos;

import java.util.Map;

import lombok.Data;

@Data
public class ErrorDto {



	private int statusCode;

	private String statusMessage;

	private Long id;

	private Map<String, String> fieldResponse;


}

	

