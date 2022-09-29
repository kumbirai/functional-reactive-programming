package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.INTEGER_LIST_SUPPLIER;

public class ColdObservables
{
	private static final Logger LOG = LoggerFactory.getLogger(ColdObservables.class);

	public static void main(String[] args)
	{
		List<Integer> list = INTEGER_LIST_SUPPLIER.get();

		Observable<Integer> source = Observable.fromIterable(list);

		LOG.info("-----X-------Original Subscriber---------X---");
		source.subscribe(val -> LOG.info("{}", val));

		list = getData(list);

		LOG.info("-----X-------New Subscriber---------X---");
		source.subscribe(val -> LOG.info("{}", val));
	}

	private static List<Integer> getData(List<Integer> list)
	{
		list.add(19);
		return list;
	}
}
