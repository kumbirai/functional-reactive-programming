package com.kumbirai.udemy.reactive.section8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Buffering
{
	private static final Logger LOG = LoggerFactory.getLogger(Buffering.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable.range(1,
						30)
				.buffer(4,
						7)
				.subscribe(val -> LOG.info("{}",
						val));

		Observable.interval(500,
						TimeUnit.MILLISECONDS)
				.buffer(1,
						TimeUnit.SECONDS,
						2)
				.subscribe(val -> LOG.info("{}",
						val));

		@NonNull Observable<Long> interval = Observable.interval(500,
				TimeUnit.MILLISECONDS);

		Observable.interval(1_000,
						TimeUnit.MILLISECONDS)
				.window(interval)
				.subscribe(val -> LOG.info("{}",
						val));

		Thread.sleep(10_000);
	}
}
