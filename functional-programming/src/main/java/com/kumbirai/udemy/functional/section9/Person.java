package com.kumbirai.udemy.functional.section9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Person
{
	@NonNull
	private String lastName;
	private String firstName;
	@NonNull
	private int age;
}
