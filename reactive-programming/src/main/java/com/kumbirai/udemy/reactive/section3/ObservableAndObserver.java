package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObservableAndObserver
{
	private static final Logger LOG = LoggerFactory.getLogger(ObservableAndObserver.class);

	public static void main(String[] args)
	{
		Observable<Integer> source = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>()
		{
			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable
			{
				try
				{
					emitter.onNext(10);
					emitter.onNext(11);
					emitter.onComplete();
				}
				catch (Throwable t)
				{
					emitter.onError(t);
				}
			}
		});

		Observer<Integer> observer = new Observer<Integer>()
		{
			@Override
			public void onSubscribe(@NonNull Disposable d)
			{
				LOG.info(" Subscribed ");
			}

			@Override
			public void onNext(@NonNull Integer t)
			{
				LOG.info("On Next : " + t);
			}

			@Override
			public void onError(@NonNull Throwable e)
			{
				LOG.error("Error: ",
						e);
			}

			@Override
			public void onComplete()
			{
				LOG.info("Completed !");
			}
		};

		source.subscribe(observer);
	}
}
