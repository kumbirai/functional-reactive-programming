package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuilderDemo
{
	private static final Logger LOG = LoggerFactory.getLogger(BuilderDemo.class);

	public static void main(String[] args)
	{
		MobileBuilder builder = new MobileBuilder();

		Mobile myMobile = builder.with(myBuilder ->
				{
					myBuilder.ram = 4;
					myBuilder.battery = 4000;
					myBuilder.processor = "A12 Bionic";
				})
				.createMobile();

		LOG.info("{}",
				myMobile);
	}
}
