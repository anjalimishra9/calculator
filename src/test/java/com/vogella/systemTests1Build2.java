package com.vogella;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.service.CalculatorService;

public class systemTests1Build2 
{
	//////////////////////////////////////////////////
	//WARNING: THESE TESTS CAN TAKE UP TO 30 MINUTES//
	//////////////////////////////////////////////////
	
	CalculatorService calculator = new CalculatorService();
	
	@Test
	@DisplayName("a,i + b,j")
	void testDecimalPlus()
		{
			for (int i = -99 ; i <= 99 ; i++)
			{
				double a = i/10d;
				
				for (int j = -99 ; j <= 99 ; j++)
				{
					double b = j/10d;
					
					assertAll("a,i + b,j",
							() -> assertEquals(String.valueOf(a + b), calculator.calculate(String.valueOf(a)+"plus"+String.valueOf(b))));
				}				
			}
		}
	
	@Test
	@DisplayName("a,i * b,j")
	void testDecimalMultiplication()
		{
			for (int i = -99 ; i <= 99 ; i++)
			{
				double a = i/10d;
				
				for (int j = -99 ; j <= 99 ; j++)
				{
					double b = j/10d;
					
					assertAll("a,i * b,j",
							() -> assertEquals(String.valueOf(a * b), calculator.calculate(String.valueOf(a)+"multiply"+String.valueOf(b))));
				}				
			}
		}
	
	@Test
	@DisplayName("a,i / b,j")
	void testDecimalDivision()
		{
			for (int i = -99 ; i <= 99 ; i++)
			{
				double a = i/10d;
				
				for (int j = -99 ; j <= 99 ; j++)
				{
					double b = j/10d;
					
					assertAll("a,i / b,j",
							() -> assertEquals(String.valueOf(a / b), calculator.calculate(String.valueOf(a)+"divide"+String.valueOf(b))));
				}				
			}
		}
}
