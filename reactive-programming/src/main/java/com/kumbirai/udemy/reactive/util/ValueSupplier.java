package com.kumbirai.udemy.reactive.util;

import com.github.javafaker.Faker;
import com.kumbirai.udemy.reactive.section4.Employee;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValueSupplier
{
	private static final Faker FAKER = new Faker();
	public static final Supplier<List<String>> NAME_LIST_SUPPLIER = () -> IntStream.range(0,
					50)
			.boxed()
			.parallel()
			.map(val -> FAKER.name()
					.firstName())
			.sorted()
			.collect(Collectors.toList());
	public static final Supplier<List<Integer>> INTEGER_LIST_SUPPLIER = () -> IntStream.range(0,
					10)
			.boxed()
			.parallel()
			.map(val -> ThreadLocalRandom.current()
					.nextInt(100) + 1)
			.sorted()
			.collect(Collectors.toList());
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

	private ValueSupplier()
	{
	}

	public static Observable<Employee> employeeObservable()
	{
		return Observable.just(new Employee(101,
						FAKER.name()
								.firstName(),
						60_000,
						4.0),
				new Employee(123,
						FAKER.name()
								.firstName(),
						94_000,
						4.7),
				new Employee(236,
						FAKER.name()
								.firstName(),
						65_000,
						4.0),
				new Employee(155,
						FAKER.name()
								.firstName(),
						85_000,
						4.4),
				new Employee(443,
						FAKER.name()
								.firstName(),
						50_000,
						3.6),
				new Employee(127,
						FAKER.name()
								.firstName(),
						85_000,
						4.5),
				new Employee(509,
						FAKER.name()
								.firstName(),
						60_000,
						4.0),
				new Employee(344,
						FAKER.name()
								.firstName(),
						94_000,
						4.7),
				new Employee(509,
						FAKER.name()
								.firstName(),
						75_000,
						4.3),
				new Employee(344,
						FAKER.name()
								.firstName(),
						55_000,
						3.7));
	}
}
