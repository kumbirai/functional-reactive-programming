package com.kumbirai.udemy.functional.section6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalComposition
{
    private static final Logger LOG = LoggerFactory.getLogger(FunctionalComposition.class);

    public static void main(String[] args)
    {
        Function<Square, Integer> fun1 = s -> s.getArea();
        Function<Integer, Double> fun2 = area -> Math.sqrt(area);

        Function<Square, Double> getSide = fun2.compose(fun1);

        Square s = new Square();
        s.setArea(100);

        Double side = getSide.apply(s);

        LOG.info("{}",
                 side);
    }
}
