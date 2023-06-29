package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

import static com.kumbirai.udemy.functional.util.ValueSupplier.STRING_SUPPLIER;

public class SupplierPractice
{
    private static final Logger LOG = LoggerFactory.getLogger(SupplierPractice.class);

    public static void main(String[] args)
    {
        LOG.info(STRING_SUPPLIER.get());

        Supplier<Double> randomNumber = Math::random;

        LOG.info("{}",
                 randomNumber.get());
    }
}
