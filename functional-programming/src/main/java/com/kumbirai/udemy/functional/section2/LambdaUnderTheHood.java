package com.kumbirai.udemy.functional.section2;

import com.github.javafaker.Faker;
import com.kumbirai.udemy.functional.section3.MyFunInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaUnderTheHood
{
	private static final Logger LOG = LoggerFactory.getLogger(LambdaUnderTheHood.class);

	public static void main(String[] args)
	{
		MyFunInterface fun1 = new MyFunInterface()
		{
			@Override
			public void myMethod()
			{
				LOG.info("It's the implementation 1");
			}
		};
		fun1.myMethod();

		MyFunInterface fun2 = new MyFunInterface()
		{
			@Override
			public void myMethod()
			{
				var faker = new Faker();
				LOG.info(faker.gameOfThrones()
						.quote());
			}
		};
		fun2.myMethod();

		MyFunInterface fun = () -> LOG.info("I am Light Weight");
		fun.myMethod();
	}
}
