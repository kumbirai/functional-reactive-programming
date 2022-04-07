package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonExample
{
	private static final Logger LOG = LoggerFactory.getLogger(PersonExample.class);

	public static void main(String[] args)
	{
		//Suppose our use case is to find the average of ages of people in the list
		//list is:

		List<Person> list = List.of(new Person("John",
						"Anderson",
						64),
				new Person("Tom",
						"Cruise",
						57),
				new Person("Harry",
						"Potter",
						34),
				new Person("Justin",
						"Timberlake",
						38),
				new Person("Peter",
						"Pan",
						18));

		LOG.info("{}",
				list);
	}
}
