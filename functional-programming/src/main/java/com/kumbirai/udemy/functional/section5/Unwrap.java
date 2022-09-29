package com.kumbirai.udemy.functional.section5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Unwrap
{
	private static final Logger LOG = LoggerFactory.getLogger(Unwrap.class);

	public static void main(String[] args)
	{
		Integer a = 10;

		Optional<Integer> optional = Optional.of(a);

		//get

		Integer integerVal = optional.get();

		LOG.info("{}", integerVal);

		Optional<Integer> emptyOptional = Optional.empty();

		//emptyOptional.get();

		//isPresent

		Integer val = emptyOptional.isPresent() ? emptyOptional.get() : 0;
		LOG.info("{}", val);

		//orElse, orElseGet

		//orElse

		Integer orElse = emptyOptional.orElse(0);
		LOG.info("{}", orElse);

		//orElseGet

		Integer orElseGet = emptyOptional.orElseGet(() -> 0);
		LOG.info("{}", orElseGet);

		//orElseThrow

		Integer orElseThrow = emptyOptional.orElseThrow(() -> new IllegalArgumentException());

		//orElseThrow() = get()
	}
}
