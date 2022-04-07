package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatingObserver
{
	private static final Logger LOG = LoggerFactory.getLogger(CreatingObserver.class);

	public static void main(String[] args)
	{
		Observable<String> source = Observable.just("Orange",
				"Black",
				"Red");

		source.subscribe(i -> LOG.info(i),
				Throwable::printStackTrace,
				() -> LOG.info("Completed!"));

		source.subscribe(i -> LOG.info(i),
				Throwable::printStackTrace);

		source.subscribe(i -> LOG.info(i));
	}
}
