package com.kumbirai.udemy.functional.section5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.stream.Stream;

public class MoreOperations
{
	private static final Logger LOG = LoggerFactory.getLogger(MoreOperations.class);

	public static void main(String[] args)
	{
		//ifPresent
		Optional<String> optional = Optional.of("Value");

		optional.ifPresent(val -> LOG.info("This is a " + val));

		//ifPresentOrElse
		Optional.empty()
				.ifPresentOrElse(val -> LOG.info("{}",
								val),
						() -> LOG.info("Value is absent"));

		//stream
		Stream<String> stream = optional.stream();

		Optional.empty()
				.stream()
				.forEach(val -> LOG.info("{}",
						val));

		//or
		optional.or(() -> Optional.of("New Value"))
				.ifPresent(val -> LOG.info("{}",
						val));

		Optional.empty()
				.or(() -> Optional.of("New Value"))
				.ifPresent(val -> LOG.info("{}",
						val));
		//Optional.empty().or(() -> null).ifPresent(System.out :: println);

		//equals

		//optional
		//either both are empty
		//or if the values in optionals are equal to each other via equals method

		LOG.info("{}",
				optional.equals(Optional.of("Value")));

		//hashcode
		LOG.info("{}",
				Optional.empty()
						.hashCode());
	}
}
