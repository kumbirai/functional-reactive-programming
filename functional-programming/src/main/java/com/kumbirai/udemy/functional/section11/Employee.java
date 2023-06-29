package com.kumbirai.udemy.functional.section11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class Employee implements Comparable<Employee>
{
    private int id;
    private String name;
    private char gender;
    private Date dob;
    private String city;
    private String designation;
    private Date joiningDate;
    private double salary;

    @Override
    public int compareTo(Employee o)
    {
        if (this.id < o.id)
        {
            return -1;
        } else if (this.id > o.id)
        {
            return 1;
        } else
        {
            return 0;
        }
    }
}
