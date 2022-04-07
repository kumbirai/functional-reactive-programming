package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

public class BiFunctionPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(BiFunctionPractice.class);

	public static void main(String[] args)
	{
		BiFunction<String, String, Integer> biFunction = (a, b) -> (a + b).length();

		LOG.info("{}",
				biFunction.apply("Basics",
						"Strong"));
	}
}
