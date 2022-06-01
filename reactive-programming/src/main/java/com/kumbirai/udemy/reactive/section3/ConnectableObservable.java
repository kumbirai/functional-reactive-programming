package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ConnectableObservable
{
	private static final Logger LOG = LoggerFactory.getLogger(ConnectableObservable.class);

	public static void main(String[] args) throws InterruptedException
	{
		io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source = Observable.interval(1,
						TimeUnit.SECONDS)
				.publish();

		source.connect();

		LOG.info("-----X-------Original Subscriber---------X---");
		source.subscribe(val -> LOG.info("one - {}",
				val));

		Thread.sleep(10000);

		LOG.info("-----X-------New Subscriber---------X---");
		source.subscribe(val -> LOG.info("two - {}",
				val));

		Thread.sleep(10000);
	}
}
