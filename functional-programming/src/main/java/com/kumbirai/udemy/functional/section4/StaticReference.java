package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

public class StaticReference
{
	private static final Logger LOG = LoggerFactory.getLogger(StaticReference.class);

	public static void main(String[] args)
	{
		BiFunction<String, String, String> biFunction = A_Class::staticMethod;

		LOG.info(biFunction.apply("Basics",
				"Strong"));
	}
}

class A_Class
{
	static String staticMethod(String a, String b)
	{
		return a + b;
	}
}
