package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Variants
{
	private static final Logger LOG = LoggerFactory.getLogger(Variants.class);

	public static void main(String[] args)
	{
		Observable<String> source = Observable.just("Alex", "Justin", "Jack");
		Observable<String> source1 = Observable.empty();

		source1.first("Name")
				.subscribe(val -> LOG.info("{}", val));

		Single.just("Alex")
				.subscribe(val -> LOG.info("{}", val));

		source1.firstElement()
				.subscribe(val -> LOG.info("{}", val), e -> LOG.error("Error: ", e), () -> LOG.info("Maybe Completed"));

		Completable completable = Completable.complete();

		completable.subscribe(() -> LOG.info("completable Completed"));

		Completable.fromRunnable(() -> LOG.info("Some process executing"))
				.subscribe(() -> LOG.info("The process executed succesfully"));
	}
}
