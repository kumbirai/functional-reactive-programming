package com.kumbirai.udemy.functional.section14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListDemo
{
    private static final Logger LOG = LoggerFactory.getLogger(ListDemo.class);

    public static void main(String[] args)
    {
        ListFun<Integer> list = ListFun.list(3,
                                             6,
                                             9);
        list.forEach(val -> LOG.info("{}",
                                     val));

        ListFun<Integer> newList = list.addEle(56);
        newList.forEach(val -> LOG.info("{}",
                                        val));

        ListFun<Integer> removeEle = newList.removeEle(9);
        removeEle.forEach(val -> LOG.info("{}",
                                          val));

        ListFun<Integer> reverseList = removeEle.reverseList();
        reverseList.forEach(val -> LOG.info("{}",
                                            val));

        ListFun<Integer> list1 = ListFun.list(3,
                                              6,
                                              9,
                                              8);
        ListFun<Integer> list2 = ListFun.list(35,
                                              78,
                                              90);

        ListFun.concat(list1,
                       list2)
               .forEach(val -> LOG.info("{}",
                                        val));

        List<Integer> l = List.of(2,
                                  5,
                                  8,
                                  6);
        list1.addAllEle(l)
             .forEach(val -> LOG.info("{}",
                                      val));
    }
}
