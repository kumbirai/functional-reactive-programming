package com.kumbirai.udemy.functional.section10;

import com.kumbirai.udemy.functional.section9.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Spliterator;
import java.util.function.Consumer;

public class BookSpliterator implements Spliterator<Book>
{
    private static final Logger LOG = LoggerFactory.getLogger(BookSpliterator.class);
    private final Spliterator<String> baseSpliterator;
    private String name;
    private String author;
    private String genre;
    private double rating;

    public BookSpliterator(Spliterator<String> baseSpliterator)
    {
        this.baseSpliterator = baseSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Book> action)
    {
        if (this.baseSpliterator.tryAdvance(name -> this.name = name) && this.baseSpliterator.tryAdvance(author -> this.author = author) && this.baseSpliterator.tryAdvance(genre -> this.genre = genre) && this.baseSpliterator.tryAdvance(rating -> this.rating = Double.valueOf(rating)))
        {
            action.accept(new Book(this.name,
                                   this.author,
                                   this.genre,
                                   this.rating));
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Book> trySplit()
    {
        return null;
    }

    @Override
    public long estimateSize()
    {
        return baseSpliterator.estimateSize() / 4;
    }

    @Override
    public int characteristics()
    {
        return baseSpliterator.characteristics();
    }
}
