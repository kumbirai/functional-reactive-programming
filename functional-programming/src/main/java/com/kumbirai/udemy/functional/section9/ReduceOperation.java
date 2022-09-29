package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class ReduceOperation
{
	private static final Logger LOG = LoggerFactory.getLogger(ReduceOperation.class);

	public static void main(String[] args)
	{
		Integer sum = Stream.of(1, 2, 34, 56, 76, 87, 89, 90)
				.reduce(0, (a, b) -> a + b);

		// 0+9 = 9  sum
		//1 *  8 = 8 multiplication

		LOG.info("{}", sum);
	}
}
