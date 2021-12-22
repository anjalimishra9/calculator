package com.example.service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class CalculatorServiceTestContextConfiguration {
	@Bean
	public CalculatorService calculatorService() {
		return new CalculatorService();
	}
}
