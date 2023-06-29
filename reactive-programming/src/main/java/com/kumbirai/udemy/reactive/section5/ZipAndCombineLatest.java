package com.kumbirai.udemy.reactive.section5;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest
{
    private static final Logger LOG = LoggerFactory.getLogger(ZipAndCombineLatest.class);

    public static void main(String[] args) throws InterruptedException
    {
        Observable<Long> src1 = Observable.interval(200,
                                                    TimeUnit.MILLISECONDS)
                                          .take(10);

        Observable<Long> src2 = Observable.interval(1,
                                                    TimeUnit.SECONDS)
                                          .take(10);

        Observable.combineLatest(src1,
                                 src2,
                                 (e1, e2) -> "Source 1 : " + e1 + " Source 2: " + e2)
                  .subscribe(val -> LOG.info("{}",
                                             val));

        Thread.sleep(20000);
    }
}
