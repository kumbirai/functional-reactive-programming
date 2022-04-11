package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOpPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(UnaryOpPractice.class);

	public static void main(String[] args)
	{
		List<Integer> list = List.of(10,
				20,
				30,
				40,
				50);

		UnaryOperator<Integer> operator = i -> i * 100;
		List<Integer> newList = mapper(list,
				operator);
		LOG.info("{}",
				newList);
	}

	private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator)
	{
		List<T> newList = new ArrayList<>();
		list.forEach(val -> newList.add(operator.apply(val)));
		return newList;
	}
}
