package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class SupplierPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(SupplierPractice.class);

	public static void main(String[] args)
	{
		Supplier<String> stringSupplier = () -> "A String";

		LOG.info(stringSupplier.get());

		Supplier<Double> randomNumber = Math::random;

		LOG.info("{}",
				randomNumber.get());
	}
}
