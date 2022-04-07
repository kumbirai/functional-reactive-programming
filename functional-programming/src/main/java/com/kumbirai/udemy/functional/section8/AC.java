package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AC
{
	private static final Logger LOG = LoggerFactory.getLogger(AC.class);

	public void turnOn()
	{
		LOG.info("turning on AC");
	}

	public void turnOff()
	{
		LOG.info("turning off AC");
	}

	public void incTemp()
	{
		LOG.info("Increasing temperature");
	}

	public void decTemp()
	{
		LOG.info("Decreasing temperature");
	}
}
