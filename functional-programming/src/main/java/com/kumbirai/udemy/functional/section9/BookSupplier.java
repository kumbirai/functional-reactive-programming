package com.kumbirai.udemy.functional.section9;

import com.github.javafaker.Faker;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookSupplier
{
	private static final Faker FAKER = new Faker();
	public static final Supplier<List<Book>> GET_BOOKS = () -> IntStream.range(0, 1_000)
			.boxed()
			.parallel()
			.map(val -> Book.builder()
					.name(FAKER.book()
								  .title())
					.author(FAKER.book()
									.author())
					.genre(FAKER.book()
								   .genre())
					.rating(Double.parseDouble(new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH)).format(ThreadLocalRandom.current()
																																  .nextInt(5) + Math.random())))
					.build())
			.sorted(Comparator.comparingDouble(Book::getRating)
							.reversed())
			.collect(Collectors.toList());
}
