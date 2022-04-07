package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ColdObservables
{
	private static final Logger LOG = LoggerFactory.getLogger(ColdObservables.class);

	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<>();
		list.add(16);
		list.add(17);
		list.add(18);

		Observable<Integer> source = Observable.fromIterable(list);

		source.subscribe(val -> LOG.info("{}",
				val));

		list = getData(list);

		source.subscribe(val -> LOG.info("{}",
				val));
	}

	private static List<Integer> getData(List<Integer> list)
	{
		list.add(19);
		return list;
	}
	//Hot
}
