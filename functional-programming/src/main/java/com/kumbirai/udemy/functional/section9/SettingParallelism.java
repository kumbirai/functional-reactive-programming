package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static com.kumbirai.udemy.functional.section9.ParallelStreams.EMPLOYEE_LIST_SUPPLIER;

public class SettingParallelism
{
	private static final Logger LOG = LoggerFactory.getLogger(SettingParallelism.class);

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{

		LOG.info("{}", Runtime.getRuntime()
				.availableProcessors());

		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

		LOG.info("{}", ForkJoinPool.getCommonPoolParallelism());

		ForkJoinPool pool = new ForkJoinPool(2);

		List<Employee> list = EMPLOYEE_LIST_SUPPLIER.get();

		long count = pool.submit(() -> list.parallelStream()
						.filter(e -> e.getSalary() > 1_000)
						.count())
				.get();

		LOG.info("{}", count);

		//Computational Intensive

		//		Number of threads <= number of cores

		//IO intensive

		//		Number of threads > Number of cores
	}
}
