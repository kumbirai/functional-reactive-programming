package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

import static com.kumbirai.udemy.functional.util.ValueSupplier.STRING_SUPPLIER;

public class BiFunctionPractice
{
    private static final Logger LOG = LoggerFactory.getLogger(BiFunctionPractice.class);

    public static void main(String[] args)
    {
        BiFunction<String, String, Integer> biFunction = (a, b) -> (a + b).length();
        String first = STRING_SUPPLIER.get();
        String second = STRING_SUPPLIER.get();
        LOG.info("[{}][{}] - {}",
                 first,
                 second,
                 biFunction.apply(first,
                                  second));
    }
}
