package com.kumbirai.udemy.reactive.section9;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class Conversion
{
    private static final Logger LOG = LoggerFactory.getLogger(Conversion.class);

    public static void main(String[] args) throws InterruptedException, ParseException
    {
        Flowable.range(1,
                       1_000_000)
                .toObservable()
                .observeOn(Schedulers.io())
                .subscribe(e -> LOG.info("{} {}",
                                         e,
                                         Thread.currentThread()
                                               .getName()));

        Thread.sleep(5_000);
    }
}