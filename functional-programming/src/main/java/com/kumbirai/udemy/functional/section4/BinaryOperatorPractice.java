package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BinaryOperator;

public class BinaryOperatorPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(BinaryOperatorPractice.class);

	public static void main(String[] args)
	{
		BinaryOperator<String> operator = (a, b) -> a + "." + b;

		LOG.info(operator.apply("BasicsStrong",
				"com"));
	}
}
