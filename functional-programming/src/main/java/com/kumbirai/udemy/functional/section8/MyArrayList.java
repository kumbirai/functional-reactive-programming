package com.kumbirai.udemy.functional.section8;

import java.util.function.Consumer;

public class MyArrayList
{
	Object[] elements;

	public MyArrayList(Object[] elements)
	{
		this.elements = elements;
	}

	public void forEach(Consumer<Object> action)
	{
		for (int i = 0; i < elements.length; i++)
		{
			action.accept(elements[i]);
		}
	}
}
