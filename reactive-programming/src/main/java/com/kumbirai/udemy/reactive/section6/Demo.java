package com.kumbirai.udemy.reactive.section6;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;
import static com.kumbirai.udemy.reactive.util.ValueSupplier.STRING_SUPPLIER;

public class Demo
{
	private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args)
	{
		@NonNull PublishSubject<String> subject = PublishSubject.create();
		@NonNull Subject<String> serialized = subject.toSerialized();  //Thread safe

		serialized.subscribe(val -> LOG.info("{}", val));
		serialized.subscribe(e -> LOG.info("Observer 2 {}", e));

		NAME_LIST_SUPPLIER.get()
				.forEach(val -> serialized.onNext(val));
		serialized.onNext(STRING_SUPPLIER.get());
		serialized.onNext(STRING_SUPPLIER.get());
		serialized.onComplete();
		serialized.onNext(STRING_SUPPLIER.get());
	}
}
