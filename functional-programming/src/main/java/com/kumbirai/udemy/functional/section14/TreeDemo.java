package com.kumbirai.udemy.functional.section14;

//import static com.functionalds.practice.ListFun.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeDemo
{
	private static final Logger LOG = LoggerFactory.getLogger(TreeDemo.class);

	public static void main(String[] args)
	{
		TreeFun<Integer> t = TreeFun.tree(23, 5, 76, 10, 3, 45);
		TreeFun<Integer> tree = t.remove(10);
		LOG.info("{}", tree);
		LOG.info("{}", tree.isMember(50));
		LOG.info("{}", tree.max());
	}
}
