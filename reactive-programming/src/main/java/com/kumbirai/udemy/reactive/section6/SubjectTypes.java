package com.kumbirai.udemy.reactive.section6;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class SubjectTypes
{
	private static final Logger LOG = LoggerFactory.getLogger(SubjectTypes.class);

	public static void main(String[] args) throws InterruptedException
	{
		Subject<Long> subject = UnicastSubject.create();

		Observable.interval(500,
						TimeUnit.MILLISECONDS)
				.subscribe(subject);

		Thread.sleep(2000);

		subject.subscribe(e -> LOG.info("Subscriber 1: {}",
				e));

		Thread.sleep(2000);

		//		subject.onNext("a");
		//		subject.onNext("b");
		//		subject.onNext("c");
		//
		//		//subject.subscribe(e -> LOG.info("Subscriber 2: "+ e));
		//
		//		subject.onNext("d");
		//		subject.onNext("e");
		//		subject.onComplete();
	}
}
