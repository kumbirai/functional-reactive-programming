package com.kumbirai.udemy.reactive.section8;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;

public class Switching
{
    private static final Logger LOG = LoggerFactory.getLogger(Switching.class);

    public static void main(String[] args) throws InterruptedException
    {
        Observable<String> source = Observable.fromIterable(NAME_LIST_SUPPLIER.get())
                                              .concatMap(s -> Observable.just(s)
                                                                        .delay(ThreadLocalRandom.current()
                                                                                                .nextInt(500),
                                                                               TimeUnit.MILLISECONDS));

        Observable.interval(2,
                            TimeUnit.SECONDS)
                  .switchMap(s -> source.doOnDispose(() -> LOG.info("Disposing and starting again!")))
                  .subscribe(val -> LOG.info("{}",
                                             val));

        Thread.sleep(10_000);
    }
}
