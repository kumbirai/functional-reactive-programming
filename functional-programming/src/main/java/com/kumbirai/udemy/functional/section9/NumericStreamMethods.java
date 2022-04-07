package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class NumericStreamMethods
{
	private static final Logger LOG = LoggerFactory.getLogger(NumericStreamMethods.class);

	public static void main(String[] args)
	{

		//Now lets see the important methods for these primitive streams

		//Since these primitive streams are surely numeric in nature
		//,there are some very useful methods available on these numeric streams.

		//for example if we creating an int stream..then possibly we are going to 
		//perform some numerical operations on the stream..right?
		//same is true for longStream and doubleStream..

		//that's why we have a bunch of methods that we dont have for regular streams 
		// or say for object streams.
		//these methods can help us in performing calculations on the primitive 
		//present in the stream

		//so lets first talk about the methods we have for intStream:

		//sum() : returns int sum

		IntStream intStream = IntStream.of();
	/*	int sum = intStream.sum();
		LOG.info(sum);
		
		//sum method also returns 0 if the stream is empty.
		
		//max() : it returns OptionalInt
		//we talked about optionals..
		//similar to primitive or numeric streams..we also have primitive optionals.
		
		OptionalInt intOpMax = intStream.max();
		LOG.info(intOpMax);
		
		//lets run this code
		//Suppose Stream is empty..then what should get returned?
		//lets see
		
		//So if stream is empty we can'nt have 0 as the max element
		//because a stream can also have -ve ints..
		//in that case 0 will be the max element present in the stream
		//thats' why we dont get 0 as output
		//instead it is implemented to return an optional because 
		//we may have an empty stream
		//and we obviously don't want a wrong result or an exception
		//so in case we have empty stream..we get empty optional in return.
		
		
		//next is : min() : so it also returns an optional of int:
		
		OptionalInt intOpMin = intStream.min();
		LOG.info(intOpMin);
		
		//next : average() method: It returns an optional of double primitive.
		//because average can be fractional too.
		
		OptionalDouble opAvg = intStream.average(); 
		LOG.info(opAvg);
		*/
		//next method: summaryStatistics()

		//This is a very useful method for calculating max, min, avg, and sum all in
		//one go..

		IntSummaryStatistics stat = intStream.summaryStatistics();
		LOG.info("{}",
				stat);
		LOG.info("{}",
				Integer.MIN_VALUE);
		LOG.info("{}",
				Integer.MAX_VALUE);
	}
}
