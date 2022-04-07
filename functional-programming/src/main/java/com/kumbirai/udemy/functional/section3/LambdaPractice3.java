package com.kumbirai.udemy.functional.section3;

import com.kumbirai.udemy.functional.section2.LengthOfString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaPractice3
{
	private static final Logger LOG = LoggerFactory.getLogger(LambdaPractice3.class);

	public static void main(String[] args)
	{
		LengthOfString len = str ->
		{
			int l = str.length();
			LOG.info("The length of the given String is {}",
					l);
			return l;
		};

		int length = len.length("BasicsStrong");
		LOG.info("{}",
				length);
	}
}
