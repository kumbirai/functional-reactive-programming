package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;

public class NewThreadScheduler
{
	private static final Logger LOG = LoggerFactory.getLogger(NewThreadScheduler.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable<String> src = Observable.fromIterable(NAME_LIST_SUPPLIER.get())
				.subscribeOn(Schedulers.newThread());

		src.subscribe(e -> task(e));

		Thread.sleep(6000);
		src.subscribe(NewThreadScheduler::task);
		src.subscribe(NewThreadScheduler::task);
		src.subscribe(NewThreadScheduler::task);
		src.subscribe(NewThreadScheduler::task);

		Thread.sleep(500000);
	}

	public static void task(String value) throws InterruptedException
	{
		Thread.sleep(1000);
		LOG.info("Computation of '{}' Done By : {}",
				value,
				Thread.currentThread()
						.getName());
	}
}
