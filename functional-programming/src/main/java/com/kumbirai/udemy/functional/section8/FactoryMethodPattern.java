package com.kumbirai.udemy.functional.section8;

public class FactoryMethodPattern
{
	public static void main(String[] args)
	{
		Flooring floor = FlooringFactory.getFlooring(3,
				47);
		floor.installation();
	}
}
