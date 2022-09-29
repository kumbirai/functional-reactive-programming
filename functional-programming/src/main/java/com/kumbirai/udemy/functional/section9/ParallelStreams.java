package com.kumbirai.udemy.functional.section9;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.kumbirai.udemy.functional.util.ValueSupplier.INTEGER_LIST_SUPPLIER;

public class ParallelStreams
{
	private static final Logger LOG = LoggerFactory.getLogger(ParallelStreams.class);
	private static final Faker FAKER = new Faker();
	public static final Supplier<List<Employee>> EMPLOYEE_LIST_SUPPLIER = () -> IntStream.range(0, 1_000_000)
			.boxed()
			.parallel()
			.map(val -> Employee.builder()
					.name(FAKER.name()
								  .fullName())
					.salary(INTEGER_LIST_SUPPLIER.get()
									.get(ThreadLocalRandom.current()
												 .nextInt(10)) * 25)
					.build())
			.collect(Collectors.toList());

	public static void main(String[] args)
	{
		long startTime;
		long endTime;

		List<Employee> list = EMPLOYEE_LIST_SUPPLIER.get();
		LOG.info("{}", list);

		Predicate<Employee> salaryOver1000Filter = e -> e.getSalary() > 1_000;

		startTime = System.currentTimeMillis();
		LOG.info("Performing Sequentially: {}", list.stream()
				.filter(e -> salaryOver1000Filter.test(e))
				.count());

		endTime = System.currentTimeMillis();

		LOG.info("Time taken with Sequential : {}", (endTime - startTime));

		startTime = System.currentTimeMillis();
		LOG.info("Performing parallely: {}", list.parallelStream()
				.filter(e -> salaryOver1000Filter.test(e))
				.count());

		endTime = System.currentTimeMillis();

		LOG.info("Time taken with parallel : {}", (endTime - startTime));
	}
}
