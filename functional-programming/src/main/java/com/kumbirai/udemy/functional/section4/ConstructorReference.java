package com.kumbirai.udemy.functional.section4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class ConstructorReference
{
	private static final Logger LOG = LoggerFactory.getLogger(ConstructorReference.class);

	public static void main(String[] args)
	{
		Function<Runnable, Thread> threadGenerator = Thread::new;

		Runnable task1 = () -> LOG.info("Task 1 executed");
		Runnable task2 = () -> LOG.info("Task 2 executed");

		Thread thread1 = threadGenerator.apply(task1);
		Thread thread2 = threadGenerator.apply(task2);

		thread1.start();
		thread2.start();

		threadGenerator.apply(() -> LOG.info("Task 3 executed"))
				.start();
	}
}
