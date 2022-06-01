package com.kumbirai.udemy.reactive.section9;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlowableCreation
{
	private static final Logger LOG = LoggerFactory.getLogger(FlowableCreation.class);

	public static void main(String[] args) throws InterruptedException
	{
		Flowable.create(emitter ->
						{
							for (int i = 0; i <= 5_000; i++)
							{
								if (emitter.isCancelled())
								{
									return;
								}
								emitter.onNext(i);
							}

							emitter.onComplete();
						},
						BackpressureStrategy.BUFFER)
				.observeOn(Schedulers.io())
				.subscribe(val -> LOG.info("{}",
						val));

		Thread.sleep(2_000);
	}
}
