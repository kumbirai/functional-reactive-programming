package com.kumbirai.udemy.functional.section13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Test
{
	private static final Logger LOG = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args)
	{
		Reserve r = new Reserve(LocalDate.parse("2018-11-01"));

		r.setResDate(LocalDate.parse("2018-10-01"));

		LOG.info("{}",
				r.getResDate());
	}
}
