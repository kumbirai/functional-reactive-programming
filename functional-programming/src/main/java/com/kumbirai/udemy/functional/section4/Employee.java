package com.kumbirai.udemy.functional.section4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Employee
{
	private String name;
	private Integer salary;
}
