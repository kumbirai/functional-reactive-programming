package com.kumbirai.udemy.functional.section13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MapFunctionalOperations
{
	private static final Logger LOG = LoggerFactory.getLogger(MapFunctionalOperations.class);

	public static void main(String[] args)
	{
		Map<String, String> contacts = new HashMap<>();
		contacts.put("1237589020",
				"John");
		contacts.put("1237009020",
				"John");
		contacts.put("7890291111",
				"Neal");
		contacts.put("2647210290",
				"Raju");
		contacts.put("9999999999",
				"Peter");
		contacts.put("9081234567",
				"Neha");

		//traversal
		for (Map.Entry<String, String> entry : contacts.entrySet())
		{
			LOG.info("{} -{}",
					entry.getKey(),
					entry.getValue());
		}

		LOG.info("---------------------------");

		contacts.forEach((k, v) -> LOG.info("{} - {}",
				k,
				v));

		LOG.info("---------------------------");

		//Filter
		contacts.entrySet()
				.stream()
				.filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
				.forEach(val -> LOG.info("{}",
						val));

		Map<String, String> filteredContacts = contacts.entrySet()
				.stream()
				.filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
				.collect(Collectors.toMap(c -> c.getKey(),
						c -> c.getValue()));

		LOG.info("{}",
				filteredContacts);

		LOG.info("---------------------------");

		//Map
		String contactNames = contacts.entrySet()
				.stream()
				.map(c -> c.getValue())
				.distinct()
				.collect(Collectors.joining(" , "));

		LOG.info(contactNames);

		LOG.info("---------------------------");

		//sorting

		LinkedHashMap<String, String> sortedMap = contacts.entrySet()
				.stream()
				.sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(c -> c.getKey(),
						c -> c.getValue(),
						(v1, v2) -> v1,
						LinkedHashMap::new));

		sortedMap.forEach((k, v) -> LOG.info("{} - {}",
				k,
				v));
		LOG.info("---------------------------");

		//reduce 
		Map<String, Double> marks = new HashMap<>();
		marks.put("Science",
				66.00);
		marks.put("Maths",
				78.00);
		marks.put("English",
				90.00);

		OptionalDouble average = marks.values()
				.stream()
				.mapToDouble(m -> m)
				.average();

		LOG.info("{}",
				average.getAsDouble());
	}
}
