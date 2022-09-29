package com.kumbirai.udemy.reactive.section5;

import com.kumbirai.udemy.reactive.section4.Employee;
import com.kumbirai.udemy.reactive.util.ValueSupplier;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Grouping
{
	private static final Logger LOG = LoggerFactory.getLogger(Grouping.class);

	public static void main(String[] args)
	{
		Observable<Employee> obs = ValueSupplier.employeeObservable();

		obs.groupBy(Employee::getRating)
				//.flatMapSingle(e -> e.toMultimap(key -> e.getKey(),
				//		employee -> employee))
				//.flatMapSingle(Observable::toList)
				.flatMapSingle(Observable::toList)
				.subscribe(val -> LOG.info("{}", val));
	}
}
