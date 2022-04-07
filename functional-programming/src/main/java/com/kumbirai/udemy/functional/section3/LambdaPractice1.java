package com.kumbirai.udemy.functional.section3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaPractice1
{
	private static final Logger LOG = LoggerFactory.getLogger(LambdaPractice1.class);

	public static void main(String[] args)
	{
		Name name = () -> LOG.info("John");
		name.myName();
	}
}
