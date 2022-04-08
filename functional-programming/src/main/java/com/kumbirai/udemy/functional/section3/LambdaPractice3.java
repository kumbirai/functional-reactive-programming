package com.kumbirai.udemy.functional.section3;

import com.github.javafaker.Faker;
import com.kumbirai.udemy.functional.section2.LengthOfString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaPractice3
{
	private static final Logger LOG = LoggerFactory.getLogger(LambdaPractice3.class);

	public static void main(String[] args)
	{
		LengthOfString len = str ->
		{
			int l = str.length();
			LOG.info("The length of the given String \"{}\" is {}",
					str,
					l);
			return l;
		};

		var faker = new Faker();
		int length = len.length(faker.backToTheFuture()
				.quote());
		LOG.info("{}",
				length);
	}
}
