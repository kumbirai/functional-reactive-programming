package com.kumbirai.udemy.reactive.section9;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Backpressure
{
	private static final Logger LOG = LoggerFactory.getLogger(Backpressure.class);

	public static void main(String[] args)
	{
		Flowable.range(1,
						1000000)
				.map(e ->
				{
					LOG.info("Produced item is : {} : ",
							e,
							Thread.currentThread()
									.getName());
					return e;
				})
				.observeOn(Schedulers.io())
				.subscribe(new Subscriber<Integer>()
				{
					Subscription s;
					final AtomicInteger count = new AtomicInteger(0);

					@Override
					public void onSubscribe(Subscription s)
					{
						this.s = s;
						LOG.info("Asking for 20 items");
						s.request(20);
					}

					@Override
					public void onNext(Integer t)
					{
						if (count.getAndIncrement() % 20 == 0)
						{
							LOG.info("Asking for next 20 items ");
							s.request(20);
						}

						LOG.info("The subscriber consumed : {}",
								t);
						sleep(100);
					}

					@Override
					public void onError(Throwable t)
					{
						LOG.error("Error: ",
								t);
					}

					@Override
					public void onComplete()
					{
						LOG.info("Completed");
					}
				});

		sleep(100000000);
	}

	private static void sleep(long milliseconds)
	{
		try
		{
			Thread.sleep(milliseconds);
		}
		catch (InterruptedException e)
		{
			LOG.error("Error: ",
					e);
		}
	}
}
