package com.kumbirai.udemy.functional.section2;

import com.kumbirai.udemy.functional.section3.MyFunInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalInterfaceDemo
{
	private static final Logger LOG = LoggerFactory.getLogger(FunctionalInterfaceDemo.class);

	public static void main(String[] args)
	{
		//		MyFunInterface fun = () -> LOG.info("hello");
		//		fun.myMethod();
		//
		//		Integer x = 100;

		onTheFly(() -> LOG.info("Hello"));
	}

	public static void onTheFly(MyFunInterface fun)
	{
		fun.myMethod();
	}
}
