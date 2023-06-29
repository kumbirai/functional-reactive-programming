package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecoratorPattern
{
    private static final Logger LOG = LoggerFactory.getLogger(DecoratorPattern.class);

    public static void main(String[] args)
    {
        Burger myOrder = new BurgerShop(burger -> burger.addCheese()).use(new BurgerShop(burger -> burger.addVeggies()).use(new Burger()));

        LOG.info("I get " + myOrder);
    }
}
