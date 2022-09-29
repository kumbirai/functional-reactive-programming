package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class BurgerShop
{
	private static final Logger LOG = LoggerFactory.getLogger(BurgerShop.class);

	Function<Burger, Burger> decoration;

	public BurgerShop(Function<Burger, Burger> decoration)
	{
		this.decoration = decoration;
	}

	public Burger use(Burger baseBurger)
	{
		LOG.info("Base Burger : {}", baseBurger);
		return decoration.apply(baseBurger);
	}
}
