package com.tax.demo.service;

import java.util.List;

import com.tax.demo.dtos.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto create(EmployeeDto employeeDto);
	
	public EmployeeDto getEmployee(Long employeeId);
	
	public List<EmployeeDto> getAllEmployees();

}
