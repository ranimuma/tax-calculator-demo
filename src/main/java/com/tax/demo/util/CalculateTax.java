package com.tax.demo.util;

import java.util.Date;

public class CalculateTax {

		public static Long getTotalSalary(Date djo, Long salaryPerMonth, int lopDays) {
			int totalWorkingDays = 10;
			double lop = salaryPerMonth / TaxConstants.LOSS_OF_PAY_PER_DAY_DIVIDER;
			return (long) lop;//TODO 
		}

		
	}


