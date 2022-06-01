package com.kumbirai.udemy.reactive.section1;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;

public class ObserverDesignPattern
{
	private static final Logger LOG = LoggerFactory.getLogger(ObserverDesignPattern.class);
	private static final Faker FAKER = new Faker();

	public static void main(String[] args)
	{
		Book book = new Book(FAKER.book()
				.title(),
				FAKER.book()
						.genre(),
				FAKER.book()
						.author(),
				FAKER.options()
						.option(150,
								200,
								250,
								300,
								350,
								400),
				"SoldOut");

		List<String> names = NAME_LIST_SUPPLIER.get();
		names.forEach(name ->
		{
			new EndUser(name,
					book);
			LOG.info("{}",
					name);
		});

		LOG.info("{}",
				book.getInStock());

		book.setInStock("In Stock");
	}
}
