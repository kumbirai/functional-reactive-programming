package com.kumbirai.udemy.functional.section5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Operations
{
	private static final Logger LOG = LoggerFactory.getLogger(Operations.class);

	public static void main(String[] args)
	{
		Optional<String> optional = Optional.of("Value");

		//map()

		String orElse = optional.map(val -> "Replaced")
				.orElse("Empty");
		LOG.info(orElse);

		//filter()

		Optional<String> filter = optional.filter(val -> val.equalsIgnoreCase("Value"));
		LOG.info(filter.get());

		//flatMap()

		Optional<String> flatMap = optional.flatMap(val -> Optional.of("Replaced By FlatMap"));
		LOG.info(flatMap.get());
	}
}
