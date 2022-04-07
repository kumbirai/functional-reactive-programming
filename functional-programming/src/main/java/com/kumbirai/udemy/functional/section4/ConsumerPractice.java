package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerPractice.class);

	public static void main(String[] args)
	{
		List<Integer> list = List.of(34,
				67,
				8,
				23,
				67,
				89,
				90);

		Consumer<Integer> consumer = i -> LOG.info("{}",
				i);

		consumer.accept(56);

		printElements(list,
				consumer);

		LOG.info("{}",
				Employee.class.getName());
	}

	private static <T> void printElements(List<T> list, Consumer<T> consumer)
	{
		for (T t : list)
		{
			consumer.accept(t);
		}
	}
}
