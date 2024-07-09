package com.tax.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.demo.dtos.EmployeeDto;
import com.tax.demo.dtos.TaxDto;
import com.tax.demo.util.CalculateTax;

@Service
public class EmployeeTaxServiceImpl implements EmployeeTaxService {

	@Autowired
	EmployeeService employeeService;
	
	@Override
	public List<TaxDto> getEmployeesTax() {
		
		List<EmployeeDto> employeesDto = employeeService.getAllEmployees();
		List<TaxDto> employeesTaxDto = new ArrayList<TaxDto>();
		for(EmployeeDto employeeDto : employeesDto) {
			TaxDto taxDto = getEmployeeTax(employeeDto);
			employeesTaxDto.add(taxDto);
		}
		return employeesTaxDto;
		
	}
	
	public TaxDto getEmployeeTax(EmployeeDto employeeDto) {
		TaxDto employeeTaxDto = new TaxDto();
		employeeTaxDto.setEmployeeID(employeeDto.getEmployeeId());
		employeeTaxDto.setFirstName(employeeDto.getFirstName());
		employeeTaxDto.setDoj(employeeDto.getDoj());
		employeeTaxDto.setLastName(employeeDto.getLastName());
		employeeTaxDto.setSalaryYearly(0L);//TODO
		employeeTaxDto.setTaxAmount(0d);//TODO
		employeeTaxDto.setCessAmount(0d);//TODO
		return employeeTaxDto;
	}

}
