package com.kumbirai.udemy.functional.section13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetFunctionalOperations
{
	private static final Logger LOG = LoggerFactory.getLogger(SetFunctionalOperations.class);

	public static void main(String[] args)
	{
		Set<Integer> set = Set.of(3,
				56,
				7,
				82,
				39);

		//traversal
		set.forEach(val -> LOG.info("{}",
				val));

		LOG.info("--------------------");

		//Filter
		set.stream()
				.filter(e -> e % 2 == 0)
				.forEach(val -> LOG.info("{}",
						val));

		LOG.info("--------------------");

		//Sorting
		set.stream()
				.sorted()
				.forEach(val -> LOG.info("{}",
						val));

		LOG.info("--------------------");

		TreeSet<Integer> sortedSet = set.stream()
				.collect(Collectors.toCollection(TreeSet::new));

		sortedSet.forEach(val -> LOG.info("{}",
				val));

		LOG.info("--------------------");

		//Map
		Set<Double> hashSet = set.stream()
				.map(e -> Double.valueOf(e))
				.collect(Collectors.toSet());

		hashSet.forEach(val -> LOG.info("{}",
				val));

		LOG.info("--------------------");

		//reduce
		int sum = set.stream()
				.mapToInt(e -> e)
				.sum();

		LOG.info("{}",
				sum);
	}
}
