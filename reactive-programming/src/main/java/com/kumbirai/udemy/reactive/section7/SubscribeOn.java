package com.kumbirai.udemy.reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;

public class SubscribeOn
{
    private static final Logger LOG = LoggerFactory.getLogger(SubscribeOn.class);

    public static void main(String[] args) throws InterruptedException
    {
        Observable.fromIterable(NAME_LIST_SUPPLIER.get())
                  .subscribeOn(Schedulers.computation())
                  .map(String::toUpperCase)
                  .doOnNext(e -> LOG.info("{} : {}",
                                          e,
                                          Thread.currentThread()
                                                .getName()))
                  .observeOn(Schedulers.newThread())
                  .filter(e -> e.startsWith("P"))
                  .observeOn(Schedulers.io())
                  .subscribe(SubscribeOn::print);

        Thread.sleep(6000);
    }

    public static void print(String element) throws InterruptedException
    {
        LOG.info("{} : Printed By : {}",
                 element,
                 Thread.currentThread()
                       .getName());
    }
}
