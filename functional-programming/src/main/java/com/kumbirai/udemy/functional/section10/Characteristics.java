package com.kumbirai.udemy.functional.section10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Characteristics
{
	private static final Logger LOG = LoggerFactory.getLogger(Characteristics.class);

	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(0);
		list.add(1);

		Stream<Integer> stream = list.stream();
		Spliterator<Integer> spliterator = stream.spliterator();
		int bits = spliterator.characteristics();
		LOG.info("{}",
				Integer.bitCount(bits));

		//OR

		LOG.info("{}",
				Integer.bitCount(bits | 0x00000010));

		//And 

		LOG.info("{}",
				bits & 0x00000010);

		LOG.info("{}",
				spliterator.hasCharacteristics(0x00000010));

		long count = list.stream()
				.filter(x ->
				{
					LOG.info("mapping");
					return x == x * 2;
				})
				.count();

		LOG.info("{}",
				count);

		//		//e.g
		//		Stream.of(1,3,2,4,9)//ORDERED, SIZED
		//		.filter(i->i%2==0) // ORDERED
		//		.sorted() // ORDERED, SORTED
		//		.map(i->i+1) // ORDERED
		//		.unordered(); //
	}
}
