package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kumbirai.udemy.functional.section9.BookSupplier.GET_BOOKS;

public class MapOperation
{
    private static final Logger LOG = LoggerFactory.getLogger(MapOperation.class);

    public static void main(String[] args)
    {
        List<Integer> collect = Stream.of(1,
                                          2,
                                          3,
                                          4,
                                          5,
                                          6,
                                          7,
                                          8,
                                          9,
                                          10)
                                      .map(e -> e * 25)
                                      .collect(Collectors.toList());

        collect.forEach(e -> LOG.info("{}",
                                      e));

        List<Book> books = GET_BOOKS.get();

        books.stream()
             .filter((book) -> book.getGenre()
                                   .equalsIgnoreCase("Horror"))
             .filter((book) -> book.getRating() > 3)
             .map(book -> book.getName())
             .forEach(val -> LOG.info("{}",
                                      val));
    }
}
