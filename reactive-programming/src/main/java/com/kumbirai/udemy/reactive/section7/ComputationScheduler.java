package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComputationScheduler
{
	private static final Logger LOG = LoggerFactory.getLogger(ComputationScheduler.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable<String> src = Observable.just("Pasta",
						"Pizza",
						"Fries",
						"Curry",
						"Chow mein")
				.subscribeOn(Schedulers.computation());

		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());

		Thread.sleep(50000);
	}

	public static void compute() throws InterruptedException
	{
		Thread.sleep(1000);
		LOG.info("Computation Done By : {}",
				Thread.currentThread()
						.getName());
	}
}
