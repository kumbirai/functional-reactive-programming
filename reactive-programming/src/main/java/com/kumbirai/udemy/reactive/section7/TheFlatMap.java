package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;

public class TheFlatMap
{
	private static final Logger LOG = LoggerFactory.getLogger(TheFlatMap.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable.fromIterable(NAME_LIST_SUPPLIER.get())
				.flatMap(e -> Observable.just(e)
						.subscribeOn(Schedulers.computation())
						.map(TheFlatMap::compute))
				.subscribe(val -> LOG.info("{}",
						val));

		Thread.sleep(10000);
	}

	public static String compute(String element) throws InterruptedException
	{
		return element + " : Printed By : " + Thread.currentThread()
				.getName() + " at : " + LocalTime.now();
	}
}
