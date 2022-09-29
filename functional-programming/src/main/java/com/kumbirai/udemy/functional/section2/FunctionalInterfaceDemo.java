package com.kumbirai.udemy.functional.section2;

import com.github.javafaker.Faker;
import com.kumbirai.udemy.functional.section3.MyFunInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalInterfaceDemo
{
	private static final Logger LOG = LoggerFactory.getLogger(FunctionalInterfaceDemo.class);

	public static void main(String[] args)
	{
		var faker = new Faker();
		MyFunInterface fun = () -> LOG.info(faker.chuckNorris()
													.fact());
		fun.myMethod();

		onTheFly(() -> LOG.info(faker.chuckNorris()
										.fact()));
	}

	public static void onTheFly(MyFunInterface fun)
	{
		fun.myMethod();
	}
}
