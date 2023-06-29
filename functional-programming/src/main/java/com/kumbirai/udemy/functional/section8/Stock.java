package com.kumbirai.udemy.functional.section8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class Stock
{
    private String symbol;
    private double price;
    private double units;
}
