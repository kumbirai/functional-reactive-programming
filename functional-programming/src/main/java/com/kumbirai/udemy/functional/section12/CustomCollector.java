package com.kumbirai.udemy.functional.section12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

import static com.kumbirai.udemy.functional.util.ValueSupplier.INTEGER_LIST_SUPPLIER;

public class CustomCollector
{
	private static final Logger LOG = LoggerFactory.getLogger(CustomCollector.class);

	public static void main(String[] args)
	{
		List<Integer> numbers = INTEGER_LIST_SUPPLIER.get();
		numbers.addAll(INTEGER_LIST_SUPPLIER.get());
		//		numbers.addAll(INTEGER_LIST_SUPPLIER.get());

		Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(ArrayList::new
																			   //supplier
				, (list, e) -> list.add(e)
																			   //BiConsumer
				, (list1, list2) ->
																			   {
																				   list1.addAll(list2);
																				   return list1;
																			   }
																			   //BiFunction
				, Collector.Characteristics.IDENTITY_FINISH);

		List<Integer> evens = numbers.stream()
				.filter(e -> e % 2 == 0)
				.collect(toList);

		evens.forEach(val -> LOG.info("{}", val));

		LOG.info("----------------");

		Collector<Integer, List<Integer>, List<Integer>> toSortedListCollector = Collector.of(ArrayList::new,
																							  //supplier
																							  (list, e) -> list.add(e),
																							  //BiConsumer
																							  (list1, list2) ->
																							  {
																								  list1.addAll(list2);
																								  return list1;
																							  }, (list) ->
																							  {
																								  Collections.sort(list);
																								  return list;
																							  }, Collector.Characteristics.UNORDERED);

		List<Integer> sortedList = numbers.stream()
				.collect(toSortedListCollector);

		sortedList.forEach(val -> LOG.info("{}", val));
	}
}
