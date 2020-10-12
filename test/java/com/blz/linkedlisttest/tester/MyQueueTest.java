package com.blz.linkedlisttest.tester;

import org.junit.Test;

import com.blz.linkedlist.model.INode;
import com.blz.linkedlist.model.MyQueue;
import com.blz.linkedlist.model.MyStack;
import com.blz.linkedlistmain.runner.MyNode;

import junit.framework.Assert;

public class MyQueueTest {
	@Test
	public void given3NumbersWhenAddedToQueueShouldHaveLastAddedNode() {
		MyQueue myQueue=new MyQueue();
		MyNode<Integer> firstNode = new MyNode<>(70);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(56);
		myQueue.enQueue(firstNode);
		myQueue.enQueue(secondNode);
		myQueue.enQueue(thirdNode);
		INode myNode=myQueue.peak();
		myQueue.printQueue();
		System.out.println(myNode.getKey());
		Assert.assertEquals(thirdNode, myNode);
	}
}
