package com.kumbirai.udemy.functional.section6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReferentialTransparency
{
	private static final Logger LOG = LoggerFactory.getLogger(ReferentialTransparency.class);

	public static void main(String[] args)
	{
		int result = add(2, multiply(2, multiply(2, multiply(2, 2))));
		LOG.info("{}", result);
	}

	public static int add(int a, int b)
	{
		return a + b;
	}

	public static int multiply(int a, int b)
	{
		LOG.info("Multiplying a and b : {}, {}", a, b);
		return a * b;
	}
}