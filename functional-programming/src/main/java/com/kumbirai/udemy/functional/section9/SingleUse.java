package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kumbirai.udemy.functional.section9.BookSupplier.GET_BOOKS;

public class SingleUse
{
	private static final Logger LOG = LoggerFactory.getLogger(SingleUse.class);

	public static void main(String[] args)
	{
		List<Book> books = GET_BOOKS.get();

		Stream<Book> stream = books.stream();

		List<Book> popularHorrorBooks = stream.filter((book) -> book.getGenre()
						.equalsIgnoreCase("Horror"))
				.filter((book) -> book.getRating() > 3)
				.collect(Collectors.toList());

		popularHorrorBooks.forEach(val -> LOG.info("{}", val));

		List<Book> popularRomanticBooks = stream.filter((book) -> book.getGenre()
						.equalsIgnoreCase("Romance"))
				.filter((book) -> book.getRating() > 3)
				.collect(Collectors.toList());

		popularRomanticBooks.forEach(val -> LOG.info("{}", val));
	}
}
