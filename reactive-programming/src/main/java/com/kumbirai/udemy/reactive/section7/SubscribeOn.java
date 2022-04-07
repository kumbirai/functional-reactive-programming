package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscribeOn
{
	private static final Logger LOG = LoggerFactory.getLogger(SubscribeOn.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable.just("Pasta",
						"Pizza",
						"Fries",
						"Curry",
						"Chow mein")
				.subscribeOn(Schedulers.computation())
				.map(e -> e.toUpperCase())
				.doOnNext(e -> LOG.info(Thread.currentThread()
						.getName()))
				.observeOn(Schedulers.newThread())
				.filter(e -> e.startsWith("P"))
				.observeOn(Schedulers.io())
				.subscribe(e -> print(e));

		Thread.sleep(6000);
	}

	public static void print(String element) throws InterruptedException
	{
		LOG.info("{} : Printed By : {}",
				element,
				Thread.currentThread()
						.getName());
	}
}
