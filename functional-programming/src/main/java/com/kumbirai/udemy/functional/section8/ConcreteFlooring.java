package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteFlooring implements Flooring
{
	private static final Logger LOG = LoggerFactory.getLogger(ConcreteFlooring.class);

	@Override
	public void installation()
	{
		LOG.info("The Concrete flooring is installed! ");
	}
}
