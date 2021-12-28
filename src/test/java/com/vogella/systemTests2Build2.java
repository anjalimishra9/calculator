package com.vogella;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.service.CalculatorService;

public class systemTests2Build2 
{
	CalculatorService calculator = new CalculatorService();
	
	@Test
	@DisplayName("Press + twice then =")
	void testPlusTwice()
		{
			for (int i = -9 ; i <= 9 ; i++)
				{
					int a = i;
					assertAll("Expected: null",
						() -> assertEquals(null, calculator.calculate("plusplus"+String.valueOf(a))),
						() -> assertEquals(null, calculator.calculate(String.valueOf(a)+"plusplus")));
				}
		}
	
	@Test
	@DisplayName("Press - twice then =")
	void testMinusTwice()
		{
			for (int i = -9 ; i <= 9 ; i++)
				{
					int a = i;
					assertAll("Expected: null",
						() -> assertEquals(null, calculator.calculate("minusminus"+String.valueOf(a))),
						() -> assertEquals(null, calculator.calculate(String.valueOf(a)+"minusminus")));
				}
		}
	
	@Test
	@DisplayName("Press * twice then =")
	void testMultiplicationTwice()
		{
			for (int i = -9 ; i <= 9 ; i++)
				{
					int a = i;
					assertAll("Expected: null",
						() -> assertEquals(null, calculator.calculate("multiplymultiply"+String.valueOf(a))),
						() -> assertEquals(null, calculator.calculate(String.valueOf(a)+"multiplymultiply")));
				}
		}
	
	@Test
	@DisplayName("Press / twice then =")
	void testDivisionTwice()
		{
			for (int i = -9 ; i <= 9 ; i++)
				{
					int a = i;
					assertAll("Expected: null",
						() -> assertEquals(null, calculator.calculate("dividedivide"+String.valueOf(a))),
						() -> assertEquals(null, calculator.calculate(String.valueOf(a)+"dividedivide")));
				}
		}
	
	@Test
	@DisplayName("Alternate between + and -")
	void testAlternatePlusMinus()
		{
			for (int i = 0 ; i <= 9 ; i++)
				{
					float a = i;
					for (int j = 0 ; j <= 9 ; j++)
					{
						float b = j;
						
						assertAll("Odd number of minus turns the number into a negative",
								() -> assertEquals(null, calculator.calculate(String.valueOf(a)+"plusminus")),
								() -> assertEquals(String.valueOf(-b), calculator.calculate("plusminus"+String.valueOf(b))),
								() -> assertEquals(String.valueOf(a-b), calculator.calculate(String.valueOf(a)+"plusminus"+String.valueOf(b))),
								() -> assertEquals(String.valueOf(a-b), calculator.calculate(String.valueOf(a)+"minusplus"+String.valueOf(b))),
								() -> assertEquals(String.valueOf(a-b), calculator.calculate(String.valueOf(a)+"plusminusplus"+String.valueOf(b))),
								() -> assertEquals(String.valueOf(a+b), calculator.calculate(String.valueOf(a)+"plusminusplusminus"+String.valueOf(b))));
					}
				
				}
		}
}
