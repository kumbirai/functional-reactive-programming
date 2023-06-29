package com.kumbirai.udemy.reactive.section5;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FlatMapConcatMap
{
    private static final Logger LOG = LoggerFactory.getLogger(FlatMapConcatMap.class);

    public static void main(String[] args)
    {
        List<String> list = List.of("Hello",
                                    "Reactive",
                                    "Programming");

        Observable.fromIterable(list)
                  .flatMap(e -> Observable.fromArray(e.split("")))
                  .subscribe(val -> LOG.info("{}",
                                             val));
    }
}
