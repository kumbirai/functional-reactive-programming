package com.kumbirai.udemy.functional.section9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Book
{
	private String name;
	private String author;
	private String genre;
	private double rating;
}
