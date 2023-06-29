package com.kumbirai.udemy.reactive.section3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kumbirai.udemy.reactive.util.ValueSupplier.STRING_LIST_SUPPLIER;

public class CreatingObserver
{
    private static final Logger LOG = LoggerFactory.getLogger(CreatingObserver.class);

    public static void main(String[] args)
    {
        @NonNull Iterable<String> strings = STRING_LIST_SUPPLIER.get();
        Observable<String> source = Observable.fromIterable(strings);

        LOG.info("-----X-------With Complete---------X---");
        source.subscribe(LOG::info,
                         Throwable::printStackTrace,
                         () -> LOG.info("Completed!"));

        LOG.info("-----X-------Without Complete---------X---");
        source.subscribe(LOG::info,
                         Throwable::printStackTrace);

        LOG.info("-----X-------Without Error and Complete---------X---");
        source.subscribe(LOG::info);
    }
}
