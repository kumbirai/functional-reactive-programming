package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Burger
{
    private static final Logger LOG = LoggerFactory.getLogger(Burger.class);
    private String burgerType;

    public Burger()
    {
        this.burgerType = "";
    }

    private Burger(String type)
    {
        this.burgerType = type;
    }

    public Burger addVeggies()
    {
        LOG.info("Adding vegies to the burger");
        return new Burger(this.burgerType += " Veggie");
    }

    public Burger addCheese()
    {
        LOG.info("Adding cheese to the burger");
        return new Burger(this.burgerType += " Cheese");
    }

    public String toString()
    {
        return String.format("%s",
                             burgerType + " burger");
    }
}
