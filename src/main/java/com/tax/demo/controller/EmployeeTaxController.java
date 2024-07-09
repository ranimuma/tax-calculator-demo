package com.tax.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tax.demo.dtos.TaxDto;
import com.tax.demo.service.EmployeeTaxService;


@RestController
@RequestMapping("/tax/v1")
public class EmployeeTaxController {

	@Autowired
	EmployeeTaxService employeeTaxService;
	
	@GetMapping(value = "/employeeTax", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TaxDto>> getEmployeesTax() {
		try {
			return new ResponseEntity<List<TaxDto>>(employeeTaxService.getEmployeesTax(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
