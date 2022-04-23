package com.kumbirai.udemy.functional.section6;

@FunctionalInterface
public interface IFactory<T>
{
	T create();
}
