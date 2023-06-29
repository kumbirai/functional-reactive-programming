package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStreams
{
    private static final Logger LOG = LoggerFactory.getLogger(InfiniteStreams.class);

    public static void main(String[] args)
    {
        Stream.iterate(0,
                       i -> i + 1);

        //		IntStream.iterate(5, i -> i -1 )
        //		.limit(15)
        //		.forEach(val->LOG.info("{}",val));

        Stream.generate(new Random()::nextInt)
              .forEach(val -> LOG.info("{}",
                                       val));
    }
}
