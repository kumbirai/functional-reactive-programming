package com.kumbirai.udemy.functional.section8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilters
{
	private StockFilters()
	{
	}

	public static List<Stock> bySymbol(List<Stock> list, String symbol)
	{
		List<Stock> filteredData = new ArrayList<>();
		list.forEach(stock ->
					 {
						 if (stock.getSymbol()
								 .equals(symbol))
						 {
							 filteredData.add(stock);
						 }
					 });
		return filteredData;
	}

	public static List<Stock> byPriceAbove(List<Stock> list, double price)
	{
		List<Stock> filteredData = new ArrayList<>();
		list.forEach(stock ->
					 {
						 if (stock.getPrice() > price)
						 {
							 filteredData.add(stock);
						 }
					 });
		return filteredData;
	}

	public static List<Stock> filter(List<Stock> list, Predicate<Stock> p)
	{
		List<Stock> filteredData = new ArrayList<>();
		list.forEach(stock ->
					 {
						 if (p.test(stock))
						 {
							 filteredData.add(stock);
						 }
					 });
		return filteredData;
	}
}
