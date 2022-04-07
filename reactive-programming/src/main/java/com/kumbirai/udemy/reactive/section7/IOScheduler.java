package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOScheduler
{
	private static final Logger LOG = LoggerFactory.getLogger(IOScheduler.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable<String> src = Observable.just("Pasta",
						"Pizza",
						"Fries",
						"Curry",
						"Chow mein")
				.subscribeOn(Schedulers.io());

		src.subscribe(e -> ioOeration());

		Thread.sleep(6000);

		src.subscribe(e -> ioOeration());
		src.subscribe(e -> ioOeration());
		src.subscribe(e -> ioOeration());
		src.subscribe(e -> ioOeration());

		Thread.sleep(500000);
	}

	public static void ioOeration() throws InterruptedException
	{
		Thread.sleep(1000);
		LOG.info("Computation Done By : {}",
				Thread.currentThread()
						.getName());
	}
}
