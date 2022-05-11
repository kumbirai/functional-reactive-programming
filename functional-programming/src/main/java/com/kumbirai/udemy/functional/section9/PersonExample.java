package com.kumbirai.udemy.functional.section9;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonExample
{
	private static final Logger LOG = LoggerFactory.getLogger(PersonExample.class);
	private static final Faker FAKER = new Faker();
	public static final Supplier<List<Person>> PERSON_LIST_SUPPLIER = () -> IntStream.range(0,
					1_000)
			.boxed()
			.parallel()
			.map(val -> Person.builder()
					.firstName(FAKER.name()
							.firstName())
					.lastName(FAKER.name()
							.lastName())
					.age(ThreadLocalRandom.current()
							.nextInt(18,
									66))
					.build())
			.collect(Collectors.toList());

	public static void main(String[] args)
	{
		//Suppose our use case is to find the average of ages of people in the list
		//list is:

		List<Person> list = PERSON_LIST_SUPPLIER.get();

		LOG.info("{}",
				list);

		OptionalDouble average = list.parallelStream()
				.mapToInt(Person::getAge)
				.average();

		IntSummaryStatistics summaryStatistics = list.parallelStream()
				.mapToInt(Person::getAge)
				.summaryStatistics();

		LOG.info("Average Age {}",
				average.isPresent() ? average.getAsDouble() : 0);

		LOG.info("Summary Statistics {}",
				summaryStatistics);
	}
}
