package com.kumbirai.udemy.functional.section6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaClosure
{
	private static final Logger LOG = LoggerFactory.getLogger(JavaClosure.class);

	public static void main(String[] args)
	{
		int val = 111;

		Task lambda = () ->
		{
			//val = 112;
			LOG.info("{}",
					val);
			LOG.info("Task Completed");
		};

		printValue(lambda);
	}

	private static void printValue(Task lambda)
	{
		lambda.doTask();
	}
}
