package com.kumbirai.udemy.functional.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstLambdaExample
{
	private static final Logger LOG = LoggerFactory.getLogger(FirstLambdaExample.class);

	public static void main(String[] args)
	{
		var t1 = new Thread(() -> LOG.info("Thread executed"));
		t1.start();
		//Runnable
	}
}
