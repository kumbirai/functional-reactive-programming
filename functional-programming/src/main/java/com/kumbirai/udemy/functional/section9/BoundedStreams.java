package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import static com.kumbirai.udemy.functional.util.ValueSupplier.INTEGER_LIST_SUPPLIER;

public class BoundedStreams
{
	private static final Logger LOG = LoggerFactory.getLogger(BoundedStreams.class);

	public static void main(String[] args)
	{
		//1. stream() on a Collection
		List<Integer> list = List.of(1, 4, 7, 9, 4);
		Stream<Integer> streamIntegers = list.stream();

		//How we can stream a Map.
		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
		Stream<Entry<Integer, String>> entries = map.entrySet()
				.stream();
		entries.forEach(e -> LOG.info("{}", e));
		LOG.info("-----");
		Stream<String> values = map.values()
				.stream();
		values.forEach(e -> LOG.info("{}", e));
		LOG.info("-----");
		Stream<Integer> keys = map.keySet()
				.stream();
		keys.forEach(e -> LOG.info("{}", e));
		LOG.info("-----");

		//2. of() Stream class

		Stream<String> streamStrings = Stream.of("Hey! ", "Happy", "Thanksgiving");
		streamStrings.forEach(e -> LOG.info("{}", e));
		LOG.info("-----");

		//3. stream() of Arrays Class

		Integer[] integerArr = INTEGER_LIST_SUPPLIER.get()
				.toArray(new Integer[0]);
		Stream<Integer> stream = Arrays.stream(integerArr);
		stream.forEach(e -> LOG.info("{}", e));
		LOG.info("-----");

		int[] intArr = { 3,
				5,
				7,
				89,
				9 };
		IntStream stream2 = Arrays.stream(intArr);
		stream2.forEach(e -> LOG.info("{}", e));
		LOG.info("-----");

		//4. builder() of Stream class.

		Builder<Integer> builder = Stream.builder();

		builder.add(1);

		//code

		//condition

		builder.add(4);

		builder.build()
				.forEach(e -> LOG.info("{}", e));
	}
}
