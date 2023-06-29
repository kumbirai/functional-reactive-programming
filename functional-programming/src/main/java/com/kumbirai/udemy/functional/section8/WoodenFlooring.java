package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WoodenFlooring implements Flooring
{
    private static final Logger LOG = LoggerFactory.getLogger(WoodenFlooring.class);

    @Override
    public void installation()
    {
        LOG.info("The Wooden flooring is installed! ");
    }
}
