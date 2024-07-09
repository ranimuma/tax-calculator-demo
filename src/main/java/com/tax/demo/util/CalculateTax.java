package com.tax.demo.util;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CalculateTax {

	  public static double getTotalSalary(Date dateOfJoining, Double salaryPerMonth, int lopdays) {
		 	LocalDate joiningDate = dateOfJoining.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 	
			int fyEndYear = LocalDate.now().getYear();
	        // Calculate number of months between joining and end date

			LocalDate fyEndate =financialYear(joiningDate);

			//No of working days in that month
	        long days = ChronoUnit.DAYS.between(joiningDate.withDayOfMonth(joiningDate.getDayOfMonth()), fyEndate.withDayOfMonth(fyEndate.getDayOfMonth())) + 1;

	        // Calculate salary for full months
	        double totalSalary = days * (salaryPerMonth/ TaxConstants.NUMBER_OF_WORKING_DAYS);

	        // Calculate loss of pay deduction based on days absent
	        double lossOfPay = (lopdays / 30.0) * salaryPerMonth; // Assuming 30 days per month

	        // Subtract loss of pay from total salary
	        totalSalary -= lossOfPay;

	        return totalSalary;
	    }

	    private static LocalDate financialYear(LocalDate joiningDate) {

	        int year = (joiningDate.getMonth() == Month.JANUARY || joiningDate.getMonth() ==Month.FEBRUARY || joiningDate.getMonth() ==Month.MARCH)
	                ? joiningDate.getYear()  : joiningDate.getYear() +1;
	        return LocalDate.of(year, 3, 31);

	    }
	    
		
		public static Double getTax(Double salary) {

			Double tax = 0.0;

			if (salary <= 250000)
				tax = 0.0;
			else if (salary <= 500000)
				tax = 0.05 * (salary - 250000);
			else if (salary <= 1000000)
				tax = (0.1 * (salary - 500000)) + (0.05 * 250000);
			else
				tax = (0.2 * (salary - 1000000)) + (0.1 * 500000) + (0.05 * 250000);

			return round(tax, 2);
		}

		public static double round(double value, int places) {
			if (places < 0)
				throw new IllegalArgumentException();

			long factor = (long) Math.pow(10, places);
			value = value * factor;
			long tmp = Math.round(value);
			return (double) tmp / factor;
		}

		public static Double getCess(Double salary) {

			Double totalCess = 0.0;

			if (salary > 2500000) {

				salary = (double) (Math.round(salary / 1000000.0) * 1000000);

				totalCess = (double) ((2 * salary) / 100);
			}

			return totalCess;
		}
		
	}


