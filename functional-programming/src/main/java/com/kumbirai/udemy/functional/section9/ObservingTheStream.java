package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObservingTheStream
{
	private static final Logger LOG = LoggerFactory.getLogger(ObservingTheStream.class);

	public static void main(String[] args)
	{

		List<Book> books = new ArrayList<>();

		//Stream Pipeline
		List<Book> popularHorrorBooks = books.stream()    //Source
				.filter((book) -> book.getGenre()
						.equalsIgnoreCase("Horror")) //Intermediate Op
				.filter((book) -> book.getRating() > 3) //Intermediate Op
				.collect(Collectors.toList());  //Terminal Op

		LOG.info("{}",
				popularHorrorBooks);

		//1.Source
		Stream<Book> stream = books.stream();

		//2. Intermediate Operation
		Stream<Book> horrorBooks = stream.filter((book) -> book.getGenre()
				.equalsIgnoreCase("Horror"));

		//3. Intermediate Operation
		Stream<Book> pHorrorBooks = horrorBooks.filter((book) -> book.getRating() > 3);

		//4. Terminal operation
		List<Book> collect = pHorrorBooks.collect(Collectors.toList());

		LOG.info("{}",
				collect);
	}
}
