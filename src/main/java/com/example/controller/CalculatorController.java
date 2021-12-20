package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ICalculatorService;

@RestController
@RequestMapping("/api")
public class CalculatorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	private ICalculatorService calculatorService;

	@GetMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> calculate(@RequestParam(name = "expr") String expr) {
		LOGGER.info("Provided Expression:{}", expr);
		String result = calculatorService.calculate(expr);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
