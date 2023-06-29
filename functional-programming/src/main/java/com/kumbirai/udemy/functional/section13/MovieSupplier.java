package com.kumbirai.udemy.functional.section13;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovieSupplier
{
    private static final Faker FAKER = new Faker();
    public static final Supplier<List<Movie>> MOVIE_LIST_SUPPLIER = () -> IntStream.range(0,
                                                                                          100)
                                                                                   .boxed()
                                                                                   .parallel()
                                                                                   .map(val -> Movie.builder()
                                                                                                    .name(FAKER.book()
                                                                                                               .title())
                                                                                                    .releaseYear(GregorianCalendar.getInstance()
                                                                                                                                  .get(Calendar.YEAR) - ThreadLocalRandom.current()
                                                                                                                                                                         .nextInt(20))
                                                                                                    .industry(FAKER.options()
                                                                                                                   .option("Hollywood",
                                                                                                                           "Bollywood"))
                                                                                                    .build())
                                                                                   .collect(Collectors.toList());
}
