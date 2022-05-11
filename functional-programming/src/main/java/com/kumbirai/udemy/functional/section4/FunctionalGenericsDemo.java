package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.functional.util.ValueSupplier.STRING_SUPPLIER;

public class FunctionalGenericsDemo
{
	public static final int MAX_INDEX = 5;
	private static final Logger LOG = LoggerFactory.getLogger(FunctionalGenericsDemo.class);

	public static void main(String[] args)
	{
		FunctionalGenerics<String, String> fun = s -> s.length() > MAX_INDEX ? s.substring(1,
				MAX_INDEX) : s.substring(1);
		var first = STRING_SUPPLIER.get();
		LOG.info("<String, String> - {}, {}",
				first,
				fun.execute(first));

		FunctionalGenerics<String, Integer> fun1 = s -> s.length();
		var second = STRING_SUPPLIER.get();
		LOG.info("<String, Integer> - {}, {}",
				second,
				fun1.execute(second));
	}
}
