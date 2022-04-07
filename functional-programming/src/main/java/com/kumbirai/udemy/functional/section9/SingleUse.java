package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleUse
{
	private static final Logger LOG = LoggerFactory.getLogger(SingleUse.class);

	public static void main(String[] args)
	{
		List<Book> books = new ArrayList<>();

		books.add(new Book("The Alchemist",
				"Paulo Coelho",
				"Adventure",
				4.408789797));
		books.add(new Book("The Notebook",
				"Nicholas Sparks",
				"Romance",
				4.10));
		books.add(new Book("Horror Cocktail",
				"Robert Bloch",
				"Horror",
				2.67));
		books.add(new Book("House of Leaves",
				"Mark Z. Danielewski",
				"Horror",
				4.10908908));

		Stream<Book> stream = books.stream();

		List<Book> popularHorrorBooks = stream.filter((book) -> book.getGenre()
						.equalsIgnoreCase("Horror"))
				.filter((book) -> book.getRating() > 3)
				.collect(Collectors.toList());

		popularHorrorBooks.forEach(val -> LOG.info("{}",
				val));

		List<Book> popularRomanticBooks = stream.filter((book) -> book.getGenre()
						.equalsIgnoreCase("Romance"))
				.filter((book) -> book.getRating() > 3)
				.collect(Collectors.toList());

		popularRomanticBooks.forEach(val -> LOG.info("{}",
				val));
	}
}
