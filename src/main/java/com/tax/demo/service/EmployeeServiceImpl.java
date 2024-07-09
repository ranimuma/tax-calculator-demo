package com.tax.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.demo.dtos.EmployeeDto;
import com.tax.demo.entity.Employee;
import com.tax.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto create(EmployeeDto employeeDto) {
		Employee employee = employeeRepository.save(new ModelMapper().map(employeeDto, Employee.class));
		EmployeeDto returnEmployeeDto = new ModelMapper().map(employee, EmployeeDto.class);
		returnEmployeeDto.setPhoneNumber(
				Stream.of(employee.getPhoneNumber().replaceAll("\\[", "").replaceAll("\\]", "").split(",", -1))
						.collect(Collectors.toList()));
		return returnEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployee(Long employeeId) {
		Employee employee = employeeRepository.findByEmployeeID(employeeId);
		EmployeeDto employeeDto = new ModelMapper().map(employee, EmployeeDto.class);
		return employeeDto;

	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> employeesDto = new ArrayList<>();
		employees.stream().forEach(employee -> {
			EmployeeDto employeeDto = new ModelMapper().map(employee, new TypeToken<EmployeeDto>() {
			}.getType());
			employeesDto.add(employeeDto);
		});
		return employeesDto;
	}

}
