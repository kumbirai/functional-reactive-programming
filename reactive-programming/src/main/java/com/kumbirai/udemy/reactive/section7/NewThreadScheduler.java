package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewThreadScheduler
{
	private static final Logger LOG = LoggerFactory.getLogger(NewThreadScheduler.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable<String> src = Observable.just("Pasta",
						"Pizza",
						"Fries",
						"Curry",
						"Chow mein")
				.subscribeOn(Schedulers.newThread());

		src.subscribe(e -> task());

		Thread.sleep(6000);
		src.subscribe(e -> task());
		src.subscribe(e -> task());
		src.subscribe(e -> task());
		src.subscribe(e -> task());

		Thread.sleep(500000);
	}

	public static void task() throws InterruptedException
	{
		Thread.sleep(1000);
		LOG.info("Computation Done By : {}",
				Thread.currentThread()
						.getName());
	}
}
