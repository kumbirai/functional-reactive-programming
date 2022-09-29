package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams
{
	private static final Logger LOG = LoggerFactory.getLogger(NumericStreams.class);

	public static void main(String[] args)
	{
		List<Book> list = BookSupplier.GET_BOOKS.get();

		OptionalDouble average = list.stream()
				.mapToDouble(book -> book.getRating())
				.average();

		LOG.info("{}", average.getAsDouble());

		//map : Objects

		//mapToDouble : primitive double

		IntStream intS = IntStream.of(1, 3, 5, 8);
		DoubleStream doubleS = DoubleStream.of(1, 3, 5, 8);
		LongStream longS = LongStream.of(1L, 3L, 5L, 8L);

		Stream<Integer> boxedInts = intS.boxed();

		doubleS.mapToObj(val -> val);
	}

}
