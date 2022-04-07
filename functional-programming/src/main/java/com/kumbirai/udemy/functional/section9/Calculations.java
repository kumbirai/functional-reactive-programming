package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculations
{
	private static final Logger LOG = LoggerFactory.getLogger(Calculations.class);

	public static void main(String[] args)
	{
		//IntStream
		//DoubleStream
		//LongStream

		//Sum

		int sum = IntStream.of()
				.sum();

		LOG.info("{}",
				sum);

		//max() Optional : primitive

		OptionalInt maxOptional = IntStream.of(1,
						3,
						4,
						5)
				.max();

		LOG.info("{}",
				maxOptional.getAsInt());

		//min() : Optional Primitive

		OptionalInt minOptional = IntStream.of(1,
						2,
						3,
						4)
				.min();

		LOG.info("{}",
				minOptional.getAsInt());

		//average() OptionalDouble

		OptionalDouble avgOptional = IntStream.of(1,
						2,
						3,
						4)
				.average();

		LOG.info("{}",
				avgOptional.getAsDouble());

		//summaryStatistics()

		IntSummaryStatistics summaryStatistics = IntStream.of(1,
						2,
						34)
				.summaryStatistics();

		LOG.info("{}",
				summaryStatistics);
	}
}
