package com.kumbirai.udemy.functional.section4;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalGenericsDemo
{
	private static final Logger LOG = LoggerFactory.getLogger(FunctionalGenericsDemo.class);
	public static final int MAX_INDEX = 5;

	public static void main(String[] args)
	{
		var faker = new Faker();

		FunctionalGenerics<String, String> fun = s -> s.length() > MAX_INDEX ? s.substring(1,
				MAX_INDEX) : s.substring(1);
		var primordial = faker.ancient()
				.primordial();
		LOG.info("<String, String> - {}, {}",
				primordial,
				fun.execute(primordial));

		FunctionalGenerics<String, Integer> fun1 = s -> s.length();
		var titan = faker.ancient()
				.titan();
		LOG.info("<String, Integer> - {}, {}",
				titan,
				fun1.execute(titan));
	}
}
