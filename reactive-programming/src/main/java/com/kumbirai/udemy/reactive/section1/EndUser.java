package com.kumbirai.udemy.reactive.section1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndUser implements Observer
{
	private static final Logger LOG = LoggerFactory.getLogger(EndUser.class);

	String name;

	EndUser(String name, SubjectLibrary subject)
	{
		this.name = name;
		subject.subscribeObserver(this);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public void update(String avail)
	{
		LOG.info("Hello {}! we are glad to notify you that your book is now {}",
				name,
				avail);
	}
}
