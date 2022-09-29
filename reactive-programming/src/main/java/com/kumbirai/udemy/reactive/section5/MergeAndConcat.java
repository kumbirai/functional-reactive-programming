package com.kumbirai.udemy.reactive.section5;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat
{
	private static final Logger LOG = LoggerFactory.getLogger(MergeAndConcat.class);

	public static void main(String[] args) throws InterruptedException
	{
		//
		//		Observable<String> src1 = Observable.just("Ella","Alexa","Lily");
		//		Observable<String> src2 = Observable.just("Priya","Chloe");

		Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS)
				.map(e -> "src1 : " + e);
		Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS)
				.map(e -> "src2 : " + e);
		//		Observable.concat(src1, src2)
		//		.subscribe(e -> LOG.info("Received : "+ e));

		src1.mergeWith(src2)
				.subscribe(e -> LOG.info("Received : {}", e));

		Thread.sleep(20000);
	}
}
