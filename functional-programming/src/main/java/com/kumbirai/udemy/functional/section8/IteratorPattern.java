package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IteratorPattern
{
    private static final Logger LOG = LoggerFactory.getLogger(IteratorPattern.class);

    public static void main(String[] args)
    {
        MyArrayList list = new MyArrayList(new Object[]{1, 3, 5, 67, 8});

        list.forEach(val -> LOG.info("{}",
                                     val));
    }
}
