package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.kumbirai.udemy.functional.util.ValueSupplier.STRING_LIST_SUPPLIER;

public class FunctionPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(FunctionPractice.class);

	public static void main(String[] args)
	{
		List<String> list = STRING_LIST_SUPPLIER.get();
		LOG.info("{}",
				list);

		Function<String, Integer> function = String::length;

		List<Integer> lengthList = map(list,
				function);
		LOG.info("{}",
				lengthList);

		List<String> reversedList = map(list,
				val -> new StringBuilder(val).reverse()
						.toString());
		LOG.info("{}",
				reversedList);
	}

	private static <T, R> List<R> map(List<T> list, Function<T, R> function)
	{
		List<R> newList = new ArrayList<>();
		list.forEach(val -> newList.add(function.apply(val)));
		return newList;
	}
}
