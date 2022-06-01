package com.kumbirai.udemy.reactive.section6;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.STRING_SUPPLIER;

public class Subjects
{
	private static final Logger LOG = LoggerFactory.getLogger(Subjects.class);

	public static void main(String[] args) throws InterruptedException
	{
		@NonNull Observable<Integer> src1 = Observable.just(5,
						10,
						15,
						20)
				.subscribeOn(Schedulers.computation());

		Observable<Integer> src2 = Observable.just(50,
						100,
						150,
						200)
				.subscribeOn(Schedulers.computation());

		//		src1.subscribe(e -> LOG.info("{}",
		//				e));
		//		src2.subscribe(e -> LOG.info("{}",
		//				e));

		@NonNull Subject<Object> subject = PublishSubject.create();

		subject.subscribe(e -> LOG.info("{}",
				e));  //Observer 1

		subject.onNext(STRING_SUPPLIER.get());
		subject.onNext(STRING_SUPPLIER.get());
		//subject.onComplete();

		//subject.subscribe(e -> LOG.info("The element is "+ e)); //Observer 2

		src1.subscribe(subject);   //source 1
		src2.subscribe(subject);    //source 2

		Thread.sleep(9000);
	}
}
