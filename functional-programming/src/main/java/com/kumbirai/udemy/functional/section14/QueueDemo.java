package com.kumbirai.udemy.functional.section14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueDemo
{
    private static final Logger LOG = LoggerFactory.getLogger(QueueDemo.class);

    public static void main(String[] args)
    {
        QueueFun<String> q = QueueFun.queue();

        QueueFun<String> enqueue = q.enqueue("Hey")
                                    .enqueue(" How are you?")
                                    .enqueue(" Fine?");

        enqueue.forEach(val -> LOG.info("{}",
                                        val));

        QueueFun<String> dequeue = enqueue.dequeue();

        dequeue.forEach(val -> LOG.info("{}",
                                        val));

        LOG.info(dequeue.peek());

        LOG.info("{}",
                 dequeue.isEmpty());

        LOG.info("{}",
                 dequeue.size());
    }
}
