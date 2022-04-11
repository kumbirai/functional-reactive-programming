package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;

import static com.kumbirai.udemy.functional.util.ValueSupplier.INTEGER_LIST_SUPPLIER;

public class ConsumerPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerPractice.class);

	public static void main(String[] args)
	{
		List<Integer> list = INTEGER_LIST_SUPPLIER.get();

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
		list.forEach(val -> consumer.accept(val));
	}
}
