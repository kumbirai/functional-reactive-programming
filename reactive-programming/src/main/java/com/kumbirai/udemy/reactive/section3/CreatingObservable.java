package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.INTEGER_LIST_SUPPLIER;
import static com.kumbirai.udemy.reactive.util.ValueSupplier.NAME_LIST_SUPPLIER;
import static com.kumbirai.udemy.reactive.util.ValueSupplier.STRING_LIST_SUPPLIER;

public class CreatingObservable
{
    private static final Logger LOG = LoggerFactory.getLogger(CreatingObservable.class);

    public static void main(String[] args)
    {
        //create()
        Observable<Integer> source = Observable.create(e ->
                                                       {
                                                           List<Integer> integers = INTEGER_LIST_SUPPLIER.get();
                                                           integers.forEach(e::onNext);
                                                           e.onComplete();
                                                       });

        source.subscribe(val -> LOG.info("{}",
                                         val));

        //just()
        Observable<Integer> just = Observable.just(1,
                                                   2,
                                                   3,
                                                   4,
                                                   5);

        just.subscribe(val -> LOG.info("{}",
                                       val));

        //fromIterable
        List<String> strings = NAME_LIST_SUPPLIER.get();

        @NonNull Observable<String> fromIterable = Observable.fromIterable(strings);

        strings.add("------");
        strings.addAll(STRING_LIST_SUPPLIER.get());

        fromIterable.subscribe(val -> LOG.info("{}",
                                               val));

        Observable<Integer> fromRange = Observable.range(2,
                                                         9);
        fromRange.subscribe(val -> LOG.info("{}",
                                            Math.pow(val,
                                                     val)));
    }
}
