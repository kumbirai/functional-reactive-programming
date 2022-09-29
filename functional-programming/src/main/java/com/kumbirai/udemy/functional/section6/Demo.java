package com.kumbirai.udemy.functional.section6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo
{
	private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args)
	{
		int result = add(6, 12);
		LOG.info("{}", result);

	}

	public static int add(int a, int b)
	{
		return a + b;
	}

	public static int multiply(int a, int b)
	{
		log(String.format("Returning %s as the result of %s * %s", a * b, a, b));
		return a * b;
	}

	public static void log(String m)
	{
		LOG.info(m);
	}
}
