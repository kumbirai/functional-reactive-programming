package com.kumbirai.udemy.reactive.section4;

import com.kumbirai.udemy.reactive.util.ValueSupplier;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OperatorsInAction
{
	private static final Logger LOG = LoggerFactory.getLogger(OperatorsInAction.class);

	public static void main(String[] args)
	{
		Observable<Employee> obs = ValueSupplier.employeeObservable();

		obs.filter(e -> e.getRating() > 4.0)
				.sorted((e1, e2) -> Double.compare(e2.getRating(),
						e1.getRating()))
				.map(Employee::getName)
				.take(4)
				//.toList()
				.subscribe(val -> LOG.info("{}",
						val));

		List<Integer> expenses = List.of(200,
				500,
				300,
				340,
				129,
				234,
				999,
				1030,
				3400,
				890,
				996,
				789);

		Observable.fromIterable(expenses)
				.reduce(Integer::sum)
				.subscribe(val -> LOG.info("{}",
						val));
	}

}
