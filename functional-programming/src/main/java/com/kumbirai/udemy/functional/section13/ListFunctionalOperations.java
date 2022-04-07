package com.kumbirai.udemy.functional.section13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListFunctionalOperations
{
	private static final Logger LOG = LoggerFactory.getLogger(ListFunctionalOperations.class);

	public static void main(String[] args)
	{
		List<Movie> movies = Arrays.asList(new Movie("Spotlight",
						2015,
						"Hollywood"),
				new Movie("Avengers: Infinity War",
						2018,
						"Hollywood"),
				new Movie("Inception",
						2010,
						"Hollywood"),
				new Movie("Forest Gump",
						1994,
						"Hollywood"),
				new Movie("3 Idiots",
						2009,
						"Bollywood"),
				new Movie("Beauty and the beast",
						2017,
						"Hollywood"),
				new Movie("Slumdog Millionaire",
						2008,
						"Bollywood"));

		//Traversal
		movies.forEach(val -> LOG.info("{}",
				val));
		LOG.info("------------------");

		//Sorting
		movies.sort((o1, o2) -> o2.getReleaseYear() - o1.getReleaseYear());
		movies.forEach(val -> LOG.info("{}",
				val));
		LOG.info("------------------");

		movies.stream()
				.filter(movie -> movie.getIndustry()
						.equalsIgnoreCase("Bollywood"))
				.forEach(val -> LOG.info("{}",
						val));

		LOG.info("------------------");

		//Mapping
		movies.stream()
				.map(movie -> movie.getName())
				.forEach(val -> LOG.info("{}",
						val));
		LOG.info("------------------");

		//Reduce
		Optional<String> moviesString = movies.stream()
				.map(m -> m.getName())
				.reduce((m1, m2) -> m1 + " | " + m2);

		LOG.info("{}",
				moviesString);

		LOG.info("------------------");
	}
}
