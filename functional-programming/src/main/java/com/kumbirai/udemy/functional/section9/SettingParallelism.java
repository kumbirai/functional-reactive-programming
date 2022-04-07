package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SettingParallelism
{
	private static final Logger LOG = LoggerFactory.getLogger(SettingParallelism.class);

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{

		LOG.info("{}",
				Runtime.getRuntime()
						.availableProcessors());

		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
				"2");

		LOG.info("{}",
				ForkJoinPool.getCommonPoolParallelism());

		ForkJoinPool pool = new ForkJoinPool(2);

		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			list.add(new Employee("John",
					20000));
			list.add(new Employee("Rohn",
					3000));
			list.add(new Employee("Tom",
					15000));
			list.add(new Employee("Bheem",
					8000));
			list.add(new Employee("Shiva",
					200));
			list.add(new Employee("Krishna",
					50000));
		}

		long count = pool.submit(() -> list.parallelStream()
						.filter(e -> e.getSalary() > 1000)
						.count())
				.get();

		LOG.info("{}",
				count);

		//Computational Intensive

		//		Number of threads <= number of cores

		//IO intensive

		//		Number of threads > Number of cores
	}
}
