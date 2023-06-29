package com.kumbirai.udemy.functional.section9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class Employee
{
    private String name;
    private int salary;
}
