package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(FunctionPractice.class);

	public static void main(String[] args)
	{
		List<String> list = List.of("Kit",
				"Kat",
				"Shake");

		Function<String, Integer> function = String::length;

		List<Integer> newList = map(list,
				function);

		LOG.info("{}",
				newList);
	}

	private static <T, R> List<R> map(List<T> list, Function<T, R> function)
	{
		List<R> newList = new ArrayList<>();

		for (T e : list)
		{
			newList.add(function.apply(e));
		}

		return newList;
	}
}
