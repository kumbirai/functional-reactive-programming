package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static com.kumbirai.udemy.functional.util.ValueSupplier.INTEGER_LIST_SUPPLIER;

public class Calculations
{
    private static final Logger LOG = LoggerFactory.getLogger(Calculations.class);

    public static void main(String[] args)
    {
        //IntStream
        //DoubleStream
        //LongStream

        //Sum

        final var integers = INTEGER_LIST_SUPPLIER.get();
        int sum = integers.stream()
                          .mapToInt(Integer::intValue)
                          .sum();

        LOG.info("Sum: {}",
                 sum);

        //max() Optional : primitive

        OptionalInt maxOptional = integers.stream()
                                          .mapToInt(Integer::intValue)
                                          .max();

        LOG.info("Max: {}",
                 maxOptional.getAsInt());

        //min() : Optional Primitive

        OptionalInt minOptional = integers.stream()
                                          .mapToInt(Integer::intValue)
                                          .min();

        LOG.info("Min: {}",
                 minOptional.getAsInt());

        //average() OptionalDouble

        OptionalDouble avgOptional = integers.stream()
                                             .mapToInt(Integer::intValue)
                                             .average();

        LOG.info("Average: {}",
                 avgOptional.getAsDouble());

        //summaryStatistics()

        var summaryStatistics = integers.stream()
                                        .mapToInt(Integer::intValue)
                                        .summaryStatistics();

        LOG.info("{}",
                 summaryStatistics);
    }
}
