package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorkFlooring implements Flooring
{
    private static final Logger LOG = LoggerFactory.getLogger(CorkFlooring.class);

    @Override
    public void installation()
    {
        LOG.info("The Cork flooring is installed! ");
    }
}
