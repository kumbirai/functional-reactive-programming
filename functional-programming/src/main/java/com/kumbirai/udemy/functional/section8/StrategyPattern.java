package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern
{
    private static final Logger LOG = LoggerFactory.getLogger(StrategyPattern.class);

    public static void main(String[] args)
    {
        List<Stock> stockList = new ArrayList<>();

        stockList.add(new Stock("AAPL",
                                318.65,
                                10));
        stockList.add(new Stock("MSFT",
                                166.86,
                                45));
        stockList.add(new Stock("GOOGL",
                                99,
                                12.5));
        stockList.add(new Stock("AMZ",
                                1866.74,
                                45));
        stockList.add(new Stock("GOOGL",
                                1480.20,
                                3.5));
        stockList.add(new Stock("AAPL",
                                318.65,
                                8));
        stockList.add(new Stock("AMZ",
                                1866.74,
                                9));

        StockFilters.bySymbol(stockList,
                              "AMZ")
                    .forEach(val -> LOG.info("{}",
                                             val));
        LOG.info("--------------------");

        StockFilters.byPriceAbove(stockList,
                                  300)
                    .forEach(val -> LOG.info("{}",
                                             val));
        LOG.info("--------------------");

        StockFilters.filter(stockList,
                            stock -> stock.getSymbol()
                                          .equals("AMZ"))
                    .forEach(val -> LOG.info("{}",
                                             val));
        LOG.info("--------------------");

        StockFilters.filter(stockList,
                            stock -> stock.getPrice() >= 400)
                    .forEach(val -> LOG.info("{}",
                                             val));
    }
}
