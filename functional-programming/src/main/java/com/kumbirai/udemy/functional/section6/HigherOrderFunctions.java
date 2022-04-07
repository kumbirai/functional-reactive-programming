package com.kumbirai.udemy.functional.section6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HigherOrderFunctions
{
	private static final Logger LOG = LoggerFactory.getLogger(HigherOrderFunctions.class);

	public static void main(String[] args)
	{
		IFactory<Integer> createFactory = createFactory(() -> Math.random() * 100,
				r -> r.intValue());
		Integer product = createFactory.create();
		LOG.info("{}",
				product);
	}

	public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator)
	{
		return () ->
		{
			T product = producer.produce();
			return configurator.configure(product);
		};
	}
}
