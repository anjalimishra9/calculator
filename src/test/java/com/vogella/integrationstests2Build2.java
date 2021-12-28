package com.vogella;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.service.CalculatorService;

public class integrationstests2Build2 
{
	// a/b
	// 0/a
	// null * a
	// a * null
	// a / null
	// a / 0
	
	CalculatorService calculator = new CalculatorService();
	
	@Test
	@DisplayName("a/b")
	void testDivision()
	{        
	     for (int i = -9 ; i <= 9 ; i++)
	     	{
	     		double a = i;
	     		
	     		for (int j = -9 ; j <= 9 ; j++)
	     		{
	     			double b = j;
     				
	     			assertAll("a/b",
	     			     () -> assertEquals(String.valueOf(a/b), calculator.calculate(String.valueOf(a) +"divide"+ String.valueOf(b))));
	     		}
	     	}
	}

	@Test
	@DisplayName("null*a && a*null")
	void testNullMultiplication()
	{
		for (int i = -9 ; i <= 9 ; i++)
		{
			int a = i;
			
			assertAll("null*a && a*null",
					() -> assertEquals(null, calculator.calculate("multiply"+ String.valueOf(a))),
					() -> assertEquals(null, calculator.calculate(String.valueOf(a)+ "multiply")));
		}
	}
	
	@Test
	@DisplayName("null/a && a/null")
	void testNullDivision()
	{
		for (int i = -9 ; i <= 9 ; i++)
		{
			int a = i;
			
			assertAll("null/a && a/null",
					() -> assertEquals(null, calculator.calculate("divide"+ String.valueOf(a))),
					() -> assertEquals(null, calculator.calculate(String.valueOf(a)+ "divide")));
		}
	}
}