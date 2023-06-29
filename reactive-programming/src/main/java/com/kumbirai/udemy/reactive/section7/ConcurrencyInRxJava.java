package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.STRING_SUPPLIER;

public class ConcurrencyInRxJava
{
    private static final Logger LOG = LoggerFactory.getLogger(ConcurrencyInRxJava.class);

    public static void main(String[] args)
    {
        Observable<String> source = Observable.create(e ->
                                                      {
                                                          new Thread(() ->
                                                                     {
                                                                         e.onNext(STRING_SUPPLIER.get());
                                                                         e.onNext(STRING_SUPPLIER.get());
                                                                     }).start();
                                                      });

        source.subscribe(e -> LOG.info("Observer 1 :{} Thread is :{}",
                                       e,
                                       Thread.currentThread()
                                             .getName()));

        source.subscribe(e -> LOG.info("Observer 2 :{} Thread is :{}",
                                       e,
                                       Thread.currentThread()
                                             .getName()));
    }
}
