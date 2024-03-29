package com.kumbirai.udemy.reactive.section1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Book implements SubjectLibrary
{
    private static final Logger LOG = LoggerFactory.getLogger(Book.class);
    private String name;
    private String type;
    private String author;
    private double price;
    private String inStock;
    private ArrayList<Observer> obsList = new ArrayList<Observer>();

    public Book(String name,
                String type,
                String author,
                double price,
                String inStock)
    {
        this.name = name;
        this.type = type;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getInStock()
    {
        return inStock;
    }

    public void setInStock(String inStock)
    {
        this.inStock = inStock;
        LOG.info("Availability changed from Sold out to Back in stock");
        notifyObserver();
    }

    public ArrayList<Observer> getObsList()
    {
        return obsList;
    }

    public void setObsList(ArrayList<Observer> obsList)
    {
        this.obsList = obsList;
    }

    @Override
    public void subscribeObserver(Observer ob)
    {
        obsList.add(ob);
    }

    @Override
    public void unsubscribeObserver(Observer ob)
    {
        obsList.remove(ob);
    }

    @Override
    public void notifyObserver()
    {
        LOG.info("Book:: [Title: {}, Genre: {}, Price: {}, Author: {}], is now {}. Please notify all users.",
                 this.name,
                 this.type,
                 this.price,
                 this.author,
                 this.inStock);

        obsList.parallelStream()
               .forEach(observer -> observer.update(this.inStock));
    }
}
