package com.blz.linkedlisttest.tester;

import org.junit.Assert;
import org.junit.Test;

import com.blz.linkedlist.model.MyLinkedList;
import com.blz.linkedlistmain.runner.MyNode;

public class MyLinkedListTest {

	@Test
	public void given3NumbersWhenAddedToLinkedListShouldBeAddedOnTop() {
		MyNode<Integer> firstNode = new MyNode<>(70);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(56);

		MyLinkedList linkedListObj = new MyLinkedList();
		linkedListObj.add(firstNode);
		linkedListObj.add(secondNode);
		linkedListObj.add(thirdNode);
		linkedListObj.printNodes();
		boolean result = linkedListObj.head.equals(thirdNode) && 
				         linkedListObj.head.getNext().equals(secondNode) && 
				         linkedListObj.tail.equals(firstNode);
		Assert.assertTrue(result);
	}
}