package com.kumbirai.udemy.functional.section6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class Currying
{
	private static final Logger LOG = LoggerFactory.getLogger(Currying.class);

	public static void main(String[] args)
	{
		Function<Integer, Function<Integer, Function<Integer, Integer>>> fun1 = u -> v -> w -> u + v + w;

		Function<Integer, Function<Integer, Integer>> fun2 = fun1.apply(1);

		Function<Integer, Integer> fun3 = fun2.apply(2);

		Integer sum = fun3.apply(3);

		LOG.info("{}",
				sum);
	}
}
