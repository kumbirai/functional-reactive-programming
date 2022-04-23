package com.kumbirai.udemy.functional.section6;

@FunctionalInterface
public interface IConfigurator<T, R>
{
	R configure(T t);
}
