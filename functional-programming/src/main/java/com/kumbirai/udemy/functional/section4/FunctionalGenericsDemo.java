package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalGenericsDemo
{
	private static final Logger LOG = LoggerFactory.getLogger(FunctionalGenericsDemo.class);

	public static void main(String[] args)
	{
		FunctionalGenerics<String, String> fun = s -> s.substring(1,
				5);
		LOG.info(fun.execute("BasicsStrong"));

		FunctionalGenerics<String, Integer> fun1 = s -> s.length();
		LOG.info("{}",
				fun1.execute("BasicsStrong"));
	}
}
