package com.kumbirai.udemy.reactive.section2;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.STRING_SUPPLIER;

public class HelloRxJava
{
	private static final Logger LOG = LoggerFactory.getLogger(HelloRxJava.class);

	public static void main(String[] args)
	{
		Observable<String> source = Observable.create(e ->
													  {
														  e.onNext(STRING_SUPPLIER.get());
														  e.onNext(STRING_SUPPLIER.get());
													  });

		source.subscribe(e -> LOG.info("Observer 1: {}, Thread Name: {}", e, Thread.currentThread()
				.getName()));

		source.subscribe(e -> LOG.info("Observer 2: {}, Thread Name: {}", e, Thread.currentThread()
				.getName()));
	}
}
