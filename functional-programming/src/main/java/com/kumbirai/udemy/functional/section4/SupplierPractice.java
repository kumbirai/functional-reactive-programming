package com.kumbirai.udemy.functional.section4;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SupplierPractice
{
	private static final Logger LOG = LoggerFactory.getLogger(SupplierPractice.class);

	public static void main(String[] args)
	{
		Supplier<String> stringSupplier = () ->
		{
			var faker = new Faker();
			String val;
			switch (ThreadLocalRandom.current()
					.nextInt(5))
			{
			case 1:
				val = faker.ancient()
						.primordial();
				break;
			case 2:
				val = faker.ancient()
						.titan();
				break;
			case 3:
				val = faker.ancient()
						.god();
				break;
			case 4:
				val = faker.animal()
						.name();
				break;
			default:
				val = faker.artist()
						.name();
			}
			return val;
		};

		LOG.info(stringSupplier.get());

		Supplier<Double> randomNumber = Math::random;

		LOG.info("{}",
				randomNumber.get());
	}
}
