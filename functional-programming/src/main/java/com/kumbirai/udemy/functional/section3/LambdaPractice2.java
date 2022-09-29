package com.kumbirai.udemy.functional.section3;

import com.kumbirai.udemy.functional.section2.MathOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class LambdaPractice2
{
	private static final Logger LOG = LoggerFactory.getLogger(LambdaPractice2.class);

	public static void main(String[] args)
	{
		MathOperation add = (a, b) -> a + b;
		double addition = add.operation(10, 20);
		LOG.info("{}", addition);

		MathOperation multiply = (a, b) -> a * b;
		double multiplication = multiply.operation(10, 90);
		LOG.info("{}", multiplication);

		MathOperation divide = (a, b) -> a / b;
		double division = divide.operation(90, 10);
		LOG.info("{}", division);

		MathOperation pow = Math::pow;
		double powerOf = pow.operation(2, ThreadLocalRandom.current()
				.nextInt(5, 20));
		LOG.info("{}", powerOf);
	}
}
