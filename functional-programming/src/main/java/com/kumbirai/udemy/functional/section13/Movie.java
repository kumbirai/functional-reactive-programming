package com.kumbirai.udemy.functional.section13;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Movie
{
	private String name;
	private int releaseYear;
	private String industry;
}
