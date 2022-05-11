package com.kumbirai.udemy.functional.section11;

import java.sql.Date;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EmployeeSpliterator implements Spliterator<Employee>
{
	private final Spliterator<String> wordSpliterator;
	private int id;
	private String name;
	private char gender;
	private Date dob;
	private String city;
	private String designation;
	private Date joiningDate;
	private double salary;

	public EmployeeSpliterator(Spliterator<String> wordSpliterator)
	{
		this.wordSpliterator = wordSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Employee> action)
	{
		if (this.wordSpliterator.tryAdvance(word -> this.id = Integer.valueOf(word)) && this.wordSpliterator.tryAdvance(word -> this.name = word) && this.wordSpliterator.tryAdvance(word -> this.gender = word.charAt(0)) && this.wordSpliterator.tryAdvance(word -> this.dob = Date.valueOf(word)) && this.wordSpliterator.tryAdvance(word -> this.city = word) && this.wordSpliterator.tryAdvance(word -> this.designation = word) && this.wordSpliterator.tryAdvance(word -> this.joiningDate = Date.valueOf(word)) && this.wordSpliterator.tryAdvance(word -> this.salary = Double.valueOf(word)))
		{
			action.accept(Employee.builder()
					.id(this.id)
					.name(this.name)
					.gender(this.gender)
					.dob(this.dob)
					.city(this.city)
					.designation(this.designation)
					.joiningDate(this.joiningDate)
					.salary(this.salary)
					.build());
			return true;
		}

		return false;
	}

	@Override
	public Spliterator<Employee> trySplit()
	{
		return null;
	}

	@Override
	public long estimateSize()
	{
		return wordSpliterator.estimateSize() / 8;
	}

	@Override
	public int characteristics()
	{
		return wordSpliterator.characteristics();
	}
}
