package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;

public class CustomScheduler
{
	private static final Logger LOG = LoggerFactory.getLogger(CustomScheduler.class);

	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService executor = Executors.newFixedThreadPool(20);

		@NonNull Scheduler scheduler = Schedulers.from(executor);

		Observable<String> src = Observable.fromIterable(NAME_LIST_SUPPLIER.get())
				.subscribeOn(scheduler)
				.doFinally(executor::shutdown);

		src.subscribe(CustomScheduler::compute);
		src.subscribe(CustomScheduler::compute);
		src.subscribe(CustomScheduler::compute);
		src.subscribe(CustomScheduler::compute);
		src.subscribe(CustomScheduler::compute);
		src.subscribe(CustomScheduler::compute);

	}

	public static void compute(String value) throws InterruptedException
	{
		Thread.sleep(1000);
		LOG.info("Computation of '{}' Done By : {}",
				value,
				Thread.currentThread()
						.getName());
	}
}
