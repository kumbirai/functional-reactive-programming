package com.kumbirai.udemy.functional.util;

import com.github.javafaker.Faker;
import com.kumbirai.udemy.functional.section11.Employee;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValueSupplier
{
	public static final Supplier<List<Integer>> INTEGER_LIST_SUPPLIER = () -> IntStream.range(0,
					10)
			.boxed()
			.parallel()
			.map(val -> ThreadLocalRandom.current()
					.nextInt(100) + 1)
			.sorted()
			.collect(Collectors.toList());
	private static final Faker FAKER = new Faker();
	public static final Supplier<String> STRING_SUPPLIER = () ->
	{
		String val;
		switch (ThreadLocalRandom.current()
				.nextInt(5))
		{
		case 0:
			val = FAKER.ancient()
					.primordial();
			break;
		case 1:
			val = FAKER.ancient()
					.titan();
			break;
		case 2:
			val = FAKER.ancient()
					.god();
			break;
		case 3:
			val = FAKER.animal()
					.name();
			break;
		default:
			val = FAKER.artist()
					.name();
		}
		return val;
	};
	public static final Supplier<List<String>> STRING_LIST_SUPPLIER = () -> IntStream.range(0,
					10)
			.boxed()
			.parallel()
			.map(val -> STRING_SUPPLIER.get())
			.sorted()
			.collect(Collectors.toList());
	public static final Supplier<List<Employee>> EMPLOYEE_LIST_SUPPLIER = () -> IntStream.range(0,
					100_000)
			.boxed()
			.parallel()
			.map(val -> Employee.builder()
					.id(val)
					.name(FAKER.name()
							.fullName())
					.dob(new java.sql.Date(FAKER.date()
							.birthday(18,
									65)
							.getTime()))
					.city(FAKER.country()
							.capital())
					.designation(FAKER.job()
							.position())
					.joiningDate(new java.sql.Date(FAKER.date()
							.past(3_000,
									TimeUnit.DAYS)
							.getTime()))
					.salary(INTEGER_LIST_SUPPLIER.get()
							.get(ThreadLocalRandom.current()
									.nextInt(10)) * 25)
					.build())
			.collect(Collectors.toList());

	private ValueSupplier()
	{
	}
}
