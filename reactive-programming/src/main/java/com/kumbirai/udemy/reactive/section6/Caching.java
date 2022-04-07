package com.kumbirai.udemy.reactive.section6;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Caching
{
	private static final Logger LOG = LoggerFactory.getLogger(Caching.class);

	public static void main(String[] args) throws InterruptedException
	{
		@NonNull Observable<@NonNull Long> src = Observable.interval(1,
						TimeUnit.SECONDS)
				.cache();

		src.subscribe(e -> LOG.info("Observer 1 : {}",
				e));

		Thread.sleep(5000);

		src.subscribe(e -> LOG.info("Observer 2 : {}",
				e));

		Thread.sleep(3000);
	}
}
