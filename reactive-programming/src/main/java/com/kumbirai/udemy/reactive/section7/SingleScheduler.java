package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleScheduler
{
	private static final Logger LOG = LoggerFactory.getLogger(SingleScheduler.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable<String> src = Observable.just("Pasta",
						"Pizza",
						"Fries",
						"Curry",
						"Chow mein")
				.subscribeOn(Schedulers.single());

		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());

		Thread.sleep(500000);
	}

	public static void sensitiveTask() throws InterruptedException
	{
		Thread.sleep(1000);
		LOG.info("Computation Done By : {}",
				Thread.currentThread()
						.getName());
	}
}
