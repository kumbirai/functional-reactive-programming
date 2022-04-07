package com.kumbirai.udemy.functional.section3;

import com.kumbirai.udemy.functional.section2.MathOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaPractice2
{
	private static final Logger LOG = LoggerFactory.getLogger(LambdaPractice2.class);

	public static void main(String[] args)
	{
		MathOperation add = (a, b) -> LOG.info("{}",
				a + b);
		add.operation(10,
				20);
		MathOperation multiply = (a, b) -> LOG.info("{}",
				a * b);
		multiply.operation(10,
				90);
	}
}
