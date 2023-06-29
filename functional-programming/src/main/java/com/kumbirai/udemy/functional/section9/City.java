package com.kumbirai.udemy.functional.section9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class City
{
    //which has name of the city,
    //Temprature of the city in int
    //humidity
    //and wind
    private String name;
    private int temprature;
    private int humidity;
    private int wind;
}
