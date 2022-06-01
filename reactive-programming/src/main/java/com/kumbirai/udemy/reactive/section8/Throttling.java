package com.kumbirai.udemy.reactive.section8;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Throttling
{
	private static final Logger LOG = LoggerFactory.getLogger(Throttling.class);

	public static void main(String[] args)
	{
		Observable<String> obs = Observable.create(emitter ->
		{
			emitter.onNext("A");

			Thread.sleep(200);
			emitter.onNext("B");

			Thread.sleep(100);
			emitter.onNext("C");

			Thread.sleep(400);
			emitter.onNext("D");

			Thread.sleep(300);
			emitter.onNext("E");

			Thread.sleep(800);
			emitter.onNext("F");

			Thread.sleep(900);
			emitter.onNext("X");

			Thread.sleep(600);
			emitter.onNext("Y");

			Thread.sleep(1_000);
			emitter.onNext("Z");

			emitter.onComplete();
		});

		obs.debounce(700,
						TimeUnit.MILLISECONDS)
				.subscribe(item -> LOG.info("onNext: {}",
								item),
						Throwable::printStackTrace,
						() -> LOG.info("onComplete"));
	}
}
