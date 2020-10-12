package com.blz.linkedlisttest.tester;

import org.junit.Test;

import com.blz.linkedlist.model.INode;
import com.blz.linkedlist.model.MyStack;
import com.blz.linkedlistmain.runner.MyNode;

import junit.framework.Assert;

public class MyStackTest {

	@Test
	public void given3NumbersWhenAddedToStackShouldHaveLastAddedNode() {
		MyStack myStack=new MyStack();
		MyNode<Integer> firstNode = new MyNode<>(70);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(56);
		myStack.push(firstNode);
		myStack.push(secondNode);
		myStack.push(thirdNode);
		INode myNode=myStack.peak();
		myStack.printStack();
		System.out.println(myNode.getKey());
		Assert.assertEquals(thirdNode, myNode);
	}
}
