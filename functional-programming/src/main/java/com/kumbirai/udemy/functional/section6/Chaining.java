package com.kumbirai.udemy.functional.section6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import static com.kumbirai.udemy.functional.util.ValueSupplier.STRING_SUPPLIER;

public class Chaining
{
	private static final Logger LOG = LoggerFactory.getLogger(Chaining.class);

	public static void main(String[] args)
	{

		Consumer<String> c1 = s -> LOG.info(s);
		Consumer<String> c2 = s -> LOG.info(s);

		//	c1.accept("Hello");
		//	c2.accept("Hello");

		Consumer<String> c3 = s ->
		{
			c1.accept(s);
			c2.accept(s);

		};

		c3.accept(STRING_SUPPLIER.get());

		Consumer<String> c4 = c1.thenAccept(c2);

		c4.accept(STRING_SUPPLIER.get());

		Function<Integer, Integer> f1 = s -> s + 2;
		Function<Integer, Integer> f2 = s -> s * 2;

		Function<Integer, Integer> f3 = f1.andThen(f2);
		LOG.info("{}", f3.apply(ThreadLocalRandom.current()
										.nextInt(20)));
	}
}
