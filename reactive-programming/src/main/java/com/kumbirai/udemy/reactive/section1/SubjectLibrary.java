package com.kumbirai.udemy.reactive.section1;

public interface SubjectLibrary
{
    void subscribeObserver(Observer ob);

    void unsubscribeObserver(Observer ob);

    void notifyObserver();
}
