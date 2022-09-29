package com.kumbirai.udemy.functional.section13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static com.kumbirai.udemy.functional.section13.MovieSupplier.MOVIE_LIST_SUPPLIER;

public class ListFunctionalOperations
{
	private static final Logger LOG = LoggerFactory.getLogger(ListFunctionalOperations.class);

	public static void main(String[] args)
	{
		List<Movie> movies = MOVIE_LIST_SUPPLIER.get();

		//Traversal
		movies.forEach(val -> LOG.info("{}", val));
		LOG.info("------------------");

		//Sorting
		movies.sort((o1, o2) -> o2.getReleaseYear() - o1.getReleaseYear());
		movies.forEach(val -> LOG.info("{}", val));
		LOG.info("------------------");

		movies.stream()
				.filter(movie -> movie.getIndustry()
						.equalsIgnoreCase("Bollywood"))
				.forEach(val -> LOG.info("{}", val));

		LOG.info("------------------");

		//Mapping
		movies.stream()
				.map(movie -> movie.getName())
				.forEach(val -> LOG.info("{}", val));
		LOG.info("------------------");

		//Reduce
		Optional<String> moviesString = movies.stream()
				.map(m -> m.getName())
				.reduce((m1, m2) -> m1 + " | " + m2);

		LOG.info("{}", moviesString);

		LOG.info("------------------");
	}
}
