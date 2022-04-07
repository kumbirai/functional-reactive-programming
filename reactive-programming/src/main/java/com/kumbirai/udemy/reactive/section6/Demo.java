package com.kumbirai.udemy.reactive.section6;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo
{
	private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args)
	{
		@NonNull PublishSubject<String> subject = PublishSubject.create();
		@NonNull Subject<String> serialized = subject.toSerialized();  //Thread safe

		serialized.subscribe(val -> LOG.info("{}",
				val));
		serialized.subscribe(e -> LOG.info("Observer 2 {}",
				e));

		serialized.onNext("Hello");
		serialized.onNext("BasicsStrong");
		serialized.onComplete();
		serialized.onNext("BasicsStrong");
	}
}
