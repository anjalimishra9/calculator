package com.example.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.opentest4j.MultipleFailuresError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(CalculatorServiceTestContextConfiguration.class)
public class CalculatorServiceTest {

	@Autowired
	private CalculatorService calculatorService;

	@Test
	@DisplayName("Plus test ok")
	public void testPlusOK() {
		assertAll("Plus Test ok", () -> assertEquals("3", calculatorService.calculate("1plus2"), "Expected: 1+2 = 3"));

	}

	@Test(expected = MultipleFailuresError.class)
	@DisplayName("Plus test not ok")
	public void testPlusNotOK() {
		assertAll("Plus Test Not ok",
				() -> assertEquals("-3", calculatorService.calculate("-1minus3"), "Expected: -1-3 = -4"),
				() -> assertEquals("2", calculatorService.calculate("-1plus2"), "Expected: -1+2 = 1"));

	}
	@Test
	@DisplayName("Multiply test ok")
	public void testMultiplyOK() {
		assertAll("Multiply Test ok", () -> assertEquals("72", calculatorService.calculate("8multiply9"), "Expected: 8*9 = 72"));

	}

}
