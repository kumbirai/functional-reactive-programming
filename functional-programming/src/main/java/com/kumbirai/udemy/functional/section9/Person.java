package com.kumbirai.udemy.functional.section9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class Person
{
	private String lastName;
	private String firstName;
	private int age;
}
