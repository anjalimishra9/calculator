package com.vogella;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.service.CalculatorService;


public class calcTest 
{
	  float c;
		
	CalculatorService calculator = new CalculatorService();

	@Test
	@DisplayName("Plus test mit Fehler")	
	void testPlus()

	{
		assertAll("Plus Test mit Fehler", 
				() -> assertEquals("3", calculator.calculate("1plus2"), "Expected: 1+2 = 3"),
			    () -> assertEquals("-3", calculator.calculate("-1minus3"), "Expected: -1-3 = -4"),
			    () -> assertEquals("2", calculator.calculate("-1plus2"), "Expected: -1+2 = 1"));
	}	
		
	@Test
	@DisplayName("Plus Test mit Äquivalenzklassen")
	void testPlus2()
		{
			for (int i=-9 ; i <= 9; i++)			
			{
				float a = i;

				for (int j=-9 ; j <= 9; j++)
				{
					float b = j;
					c = a+b;
					
					assertAll("Plus Test Äquivalenzklassen",
						() -> assertEquals(String.valueOf(c), calculator.calculate(String.valueOf(a) +"plus" + String.valueOf(b))));
				}
			}
		}
	

	@Test
	@DisplayName("Multiplikationstest mit Äquivalenzklassen")
	void testMult()
		{
			for (int i=-9 ; i <= 9; i++)			
			{
				float a = i;
				
				for (int j=-9 ; j <= 9; j++)
				{
					float	b = j;
					 c = a*b;
					 
				 	assertAll("Multiplikationstest Äquivalenzklassen",
				 			() -> assertEquals(String.valueOf(c), calculator.calculate(String.valueOf(a) +"multiply" + String.valueOf(b))));
				}
			}
		}
	
	@Test
	@DisplayName("Dezimaltest")
	void testDecimal()
	{
		assertAll("Dezimaltest",
				() -> assertEquals("0.9", calculator.calculate("0.4plus0.5")),
				() -> assertEquals("0.1", calculator.calculate("0.3minus0.2")),
				() -> assertEquals("-0.9", calculator.calculate("-0.8minus0.1")),
				() -> assertEquals("-0.1", calculator.calculate("-0.8plus0.7")));
	}
}