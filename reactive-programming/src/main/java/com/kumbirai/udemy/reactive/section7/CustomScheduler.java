package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler
{
	private static final Logger LOG = LoggerFactory.getLogger(CustomScheduler.class);

	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService executor = Executors.newFixedThreadPool(20);

		@NonNull Scheduler scheduler = Schedulers.from(executor);

		Observable<String> src = Observable.just("Pasta",
						"Pizza",
						"Fries",
						"Curry",
						"Chow mein")
				.subscribeOn(scheduler)
				.doFinally(executor::shutdown);

		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());

	}

	public static void compute() throws InterruptedException
	{
		Thread.sleep(1000);
		LOG.info("Computation Done By : {}",
				Thread.currentThread()
						.getName());
	}
}
