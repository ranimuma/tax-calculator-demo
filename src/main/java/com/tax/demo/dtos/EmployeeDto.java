package com.tax.demo.dtos;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDto {

	private Long employeeId;
		
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;

	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;

	@Email(message = "Email should be valid")
	@NotEmpty
	@Size(min =10,max=100)
	private String email;

	@NotEmpty(message = "Phone Number cannot be empty")
	private List<String> phoneNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private Date doj;

	@Min(value = 0L, message = "The value must be positive")
	private Long salary;
	
	
}
