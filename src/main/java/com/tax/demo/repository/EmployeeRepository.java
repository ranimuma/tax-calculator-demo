package com.tax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tax.demo.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public Employee findByEmployeeID(Long employeeID);
}
