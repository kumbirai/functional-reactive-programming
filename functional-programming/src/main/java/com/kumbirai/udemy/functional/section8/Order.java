package com.kumbirai.udemy.functional.section8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Order
{
    private static final Logger LOG = LoggerFactory.getLogger(Order.class);
    private List<String> cart = new ArrayList<>();
    private String address = "";

    public Order()
    {
    }

    public Order(List<String> cart,
                 String address)
    {
        this.cart = cart;
        this.address = address;
    }

    public static void place(Function<Order, Order> function)
    {
        Order order = new Order();
        order = function.apply(order);
        LOG.info("Order placed!");
        LOG.info("{} items ordered by you will be delivered at '{}' by tomorrow",
                 order.cart.size(),
                 order.address);
    }

    public Order add(String item)
    {
        cart.add(item);
        LOG.info("{} added to the cart",
                 item);
        return new Order(this.cart,
                         this.address);
    }

    public Order deliverAt(String location)
    {
        this.address = location;
        LOG.info("The delivery address set by you is '{}'",
                 location);
        return new Order(this.cart,
                         this.address);
    }
}
