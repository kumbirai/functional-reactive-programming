package com.kumbirai.udemy.functional.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative
{
	private static final Logger LOG = LoggerFactory.getLogger(ImperativeVsDeclarative.class);

	public static void main(String[] args)
	{
		//Imperative
		int sumOfEvens = 0;

		for (int i = 0; i <= 100; i++)
		{
			if (i % 2 == 0)
			{
				sumOfEvens = sumOfEvens + i;
			}
		}
		LOG.info("{}",
				sumOfEvens);

		//Declarative or Functional
		sumOfEvens = IntStream.rangeClosed(0,
						100)
				.filter(i -> i % 2 == 0)
				.reduce((x, y) -> x + y)
				.getAsInt();
		LOG.info("{}",
				sumOfEvens);
	}
}
