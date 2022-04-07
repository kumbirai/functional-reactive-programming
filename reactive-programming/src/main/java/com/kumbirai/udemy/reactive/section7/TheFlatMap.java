package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

public class TheFlatMap
{
	private static final Logger LOG = LoggerFactory.getLogger(TheFlatMap.class);

	public static void main(String[] args) throws InterruptedException
	{
		Observable.just("Pasta",
						"Pizza",
						"Fries",
						"Curry",
						"Chow mein")
				.flatMap(e -> Observable.just(e)
						.subscribeOn(Schedulers.computation())
						.map(str -> compute(str)))
				.subscribe(val -> LOG.info("{}",
						val));

		Thread.sleep(7000);
	}

	public static String compute(String element) throws InterruptedException
	{
		String s = element + " : Printed By : " + Thread.currentThread()
				.getName() + " at : " + LocalTime.now();
		return s;
	}
}
