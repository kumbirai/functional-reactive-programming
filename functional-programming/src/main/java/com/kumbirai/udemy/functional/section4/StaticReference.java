package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BinaryOperator;

import static com.kumbirai.udemy.functional.util.ValueSupplier.STRING_SUPPLIER;

public class StaticReference
{
	private static final Logger LOG = LoggerFactory.getLogger(StaticReference.class);

	public static void main(String[] args)
	{
		BinaryOperator<String> operator = A_Class::staticMethod;

		String first = STRING_SUPPLIER.get();
		String second = STRING_SUPPLIER.get();
		LOG.info("[{}][{}] - {}", first, second, operator.apply(first, second));
	}
}

class A_Class
{
	static String staticMethod(String a, String b)
	{
		return String.join("", a, b);
	}
}
