package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kumbirai.udemy.functional.section9.BookSupplier.GET_BOOKS;

public class Laziness
{
    private static final Logger LOG = LoggerFactory.getLogger(Laziness.class);

    public static void main(String[] args)
    {
        List<Book> books = GET_BOOKS.get();

        Stream<Book> stream = books.stream()
                                   .filter((book) -> book.getGenre()
                                                         .equalsIgnoreCase("Horror"))
                                   .peek(book -> LOG.info("Filtered Book {}",
                                                          book))
                                   .filter((book) -> book.getRating() > 3);
        //.collect(Collectors.toList());

        LOG.info("Filtering Done !");

        collect(stream);
    }

    private static void collect(Stream<Book> stream)
    {
        List<Book> popularHorrorBooks = stream.collect(Collectors.toList());
        LOG.info("Collection done!");
        popularHorrorBooks.forEach(val -> LOG.info("{}",
                                                   val));
    }
}
