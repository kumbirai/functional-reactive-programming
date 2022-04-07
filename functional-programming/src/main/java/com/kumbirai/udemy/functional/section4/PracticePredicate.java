package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicate
{
	private static final Logger LOG = LoggerFactory.getLogger(PracticePredicate.class);

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();

		list.add("Basics");
		list.add("");
		list.add("Strong");
		list.add("");
		list.add("BasicsStrong");

		Predicate<String> predicate = s -> !s.isEmpty();

		List<String> newList = filterList(list,
				predicate);

		Predicate<String> filter = s -> s.contains("Basics");

		List<String> filteredList = filterList(list,
				filter);

		List<Integer> intList = List.of(1,
				4,
				6,
				7,
				8);

		Predicate<Integer> integerFilter = e -> e % 2 == 0;

		List<Integer> evens = filterList(intList,
				integerFilter);

		LOG.info("{}",
				newList);
		LOG.info("{}",
				filteredList);
		LOG.info("{}",
				evens);
	}

	private static <T> List<T> filterList(List<T> list, Predicate<T> predicate)
	{
		List<T> newList = new ArrayList<>();

		for (T string : list)
		{
			if (predicate.test(string))
			{
				newList.add(string);
			}
		}
		return newList;
	}
}
