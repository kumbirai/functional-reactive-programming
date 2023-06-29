package com.kumbirai.udemy.functional.section4;

@FunctionalInterface
public interface EmployeeFactory
{
    Employee getEmployee(String name,
                         Double salary);
}
