package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Disposing
{
    private static final Logger LOG = LoggerFactory.getLogger(Disposing.class);
    private static final CompositeDisposable disp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException
    {
        @NonNull Observable<Long> src = Observable.interval(1,
                                                            TimeUnit.SECONDS);

        @NonNull Disposable d1 = src.subscribe(elem -> LOG.info("Observer 1: {}",
                                                                elem));
        Disposable d2 = src.subscribe(elem -> LOG.info("Observer 2: {}",
                                                       elem));

        Thread.sleep(5000);

        disp.addAll(d1,
                    d2);

        disp.dispose();

        Thread.sleep(10000);
    }
}
