package com.example.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

	/**
	 * Method is used for calculation for given expression
	 *
	 * @param expr
	 * @return
	 */
	@Override
	public String calculate(String expr) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		String output = null;
		try {
			expr = expr.replaceAll("plus", "+").replaceAll("minus", "-").replaceAll("multiply", "*")
					.replaceAll("divide", "/");
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Result is being calculating for expression:{}", expr);
			}
			output = engine.eval("eval(" + expr + ")").toString();
		} catch (ScriptException e) {
			LOGGER.error("Error in expression evaluation!");
			new RuntimeException("Unable to process given expression : " + expr);
		}

		if (StringUtils.isEmpty(output)) {
			new RuntimeException("Output is empty for expression: " + expr);
		}
		LOGGER.info("Result of expression:{} = {}", expr, output);
		return output;
	}
}
