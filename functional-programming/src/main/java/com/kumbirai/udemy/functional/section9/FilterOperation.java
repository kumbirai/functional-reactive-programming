package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class FilterOperation
{
	private static final Logger LOG = LoggerFactory.getLogger(FilterOperation.class);

	public static void main(String[] args)
	{
		Stream.of(34,
						678,
						89,
						4,
						52,
						31,
						325,
						6)
				.filter(e -> e % 2 == 0)
				.forEach(e -> LOG.info("{}",
						e));
	}
}
