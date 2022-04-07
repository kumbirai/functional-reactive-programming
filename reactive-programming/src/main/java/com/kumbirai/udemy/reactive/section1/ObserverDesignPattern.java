package com.kumbirai.udemy.reactive.section1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObserverDesignPattern
{
	private static final Logger LOG = LoggerFactory.getLogger(ObserverDesignPattern.class);

	public static void main(String[] args)
	{
		Book book = new Book("Goosebumps",
				"Horror",
				"Xyz",
				200,
				"SoldOut");

		EndUser user1 = new EndUser("Bob",
				book);
		EndUser user2 = new EndUser("Rob",
				book);

		LOG.info("{}",
				book.getInStock());

		book.setInStock("In Stock");
	}
}
