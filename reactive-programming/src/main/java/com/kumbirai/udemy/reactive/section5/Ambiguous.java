package com.kumbirai.udemy.reactive.section5;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ambiguous
{
	private static final Logger LOG = LoggerFactory.getLogger(Ambiguous.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS)
				.take(10)
				.map(e -> "Ob 1 :" + e);
		Observable<String> ob2 = Observable.interval(10, TimeUnit.MILLISECONDS)
				.take(10)
				.map(e -> "Ob 2 :" + e);

		Observable.amb(Arrays.asList(ob1, ob2))
				.subscribe(val -> LOG.info("{}", val));

		Thread.sleep(11000);
	}
}
