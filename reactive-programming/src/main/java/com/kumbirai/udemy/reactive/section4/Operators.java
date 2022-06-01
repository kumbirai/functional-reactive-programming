package com.kumbirai.udemy.reactive.section4;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operators
{
	private static final Logger LOG = LoggerFactory.getLogger(Operators.class);

	public static void main(String[] args)
	{
		Observable.just(60,
						57,
						89,
						90,
						23,
						100,
						98)
				.filter(e -> e > 75)
				.sorted()
				.subscribe(e -> LOG.info("Grade A with {}",
						e));
	}
}
