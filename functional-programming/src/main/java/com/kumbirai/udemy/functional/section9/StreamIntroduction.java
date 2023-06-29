package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kumbirai.udemy.functional.section9.BookSupplier.GET_BOOKS;

public class StreamIntroduction
{
    public static final int FILTER_RATING = 3;
    private static final Logger LOG = LoggerFactory.getLogger(StreamIntroduction.class);

    public static void main(String[] args)
    {
        List<Book> books = GET_BOOKS.get();

        List<Book> popularHorrorBooks = new ArrayList<>();

        for (Book book : books)
        {
            if (book.getGenre()
                    .equalsIgnoreCase("Horror") && book.getRating() > FILTER_RATING)
            {
                popularHorrorBooks.add(book);
            }
        }
        popularHorrorBooks.forEach(book -> LOG.info("{}",
                                                    book));
        LOG.info("--------------");

        //after java 8
        List<Book> collect = books.parallelStream()
                                  .filter(book -> book.getGenre()
                                                      .equalsIgnoreCase("Horror"))
                                  .filter(book -> book.getRating() > FILTER_RATING)
                                  .collect(Collectors.toList());

        collect.forEach(book -> LOG.info("{}",
                                         book));
    }
}
