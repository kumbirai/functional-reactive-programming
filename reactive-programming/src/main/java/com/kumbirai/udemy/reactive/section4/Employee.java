package com.kumbirai.udemy.reactive.section4;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee
{
	private Integer id;
	private String name;
	private double salary;
	private double rating;
}
