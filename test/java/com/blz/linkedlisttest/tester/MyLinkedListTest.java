package com.blz.linkedlisttest.tester;

import org.junit.Assert;
import org.junit.Test;

import com.blz.linkedlist.model.INode;
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
		boolean result = linkedListObj.head.equals(thirdNode) && linkedListObj.head.getNext().equals(secondNode)
				&& linkedListObj.tail.equals(firstNode);
		Assert.assertTrue(result);
	}

	@Test
	public void given3NumbersWhenAddedToLinkedListShouldBeAddedAtLast() {
		MyNode<Integer> firstNode = new MyNode<>(56);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(70);

		MyLinkedList linkedListObj = new MyLinkedList();
		linkedListObj.add(firstNode);
		linkedListObj.append(secondNode);
		linkedListObj.append(thirdNode);
		linkedListObj.printNodes();
		boolean result = linkedListObj.head.equals(firstNode) && linkedListObj.head.getNext().equals(secondNode)
				&& linkedListObj.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}

	@Test
	public void given3NumbersWhenSecondNumberIsPassedToLinkedListShouldBeInserted() {
		MyNode<Integer> firstNode = new MyNode<>(56);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(70);

		MyLinkedList linkedListObj = new MyLinkedList();
		linkedListObj.add(firstNode);
		linkedListObj.append(thirdNode);
		linkedListObj.insert(firstNode, secondNode);
		linkedListObj.printNodes();
		boolean result = linkedListObj.head.equals(firstNode) && linkedListObj.head.getNext().equals(secondNode)
				&& linkedListObj.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}

	@Test
	public void givenFirstElementWhenDeletedShouldPassLinkedListResult() {
		MyNode<Integer> firstNode = new MyNode<>(70);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(56);

		MyLinkedList linkedListObj = new MyLinkedList();
		linkedListObj.add(firstNode);
		linkedListObj.add(secondNode);
		linkedListObj.add(thirdNode);
		linkedListObj.printNodes();

		INode popNode = linkedListObj.pop();
		System.out.println("Pop operation on : " + popNode.getKey());
		boolean result = linkedListObj.head.equals(secondNode) && linkedListObj.head.getNext().equals(firstNode)
				&& linkedListObj.tail.equals(firstNode);
		Assert.assertTrue(result);
	}

	@Test
	public void givenLastElementWhenDeletedShouldPassLinkedListResult() {
		MyNode<Integer> firstNode = new MyNode<>(56);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(70);

		MyLinkedList linkedListObj = new MyLinkedList();
		linkedListObj.add(firstNode);
		linkedListObj.append(secondNode);
		linkedListObj.append(thirdNode);
		linkedListObj.printNodes();

		INode popLastNode = linkedListObj.popLast();
		System.out.println("Last Pop operation on : " + popLastNode.getKey());
		boolean result = linkedListObj.head.equals(firstNode) && linkedListObj.head.getNext().equals(secondNode)
				&& linkedListObj.tail.equals(secondNode);
		Assert.assertTrue(result);
	}

	@Test
	public void givenElementWhenSearchedShouldPassLinkedListResult() {
		MyNode<Integer> firstNode = new MyNode<>(70);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(56);

		MyLinkedList linkedListObj = new MyLinkedList();
		linkedListObj.add(firstNode);
		linkedListObj.add(secondNode);
		linkedListObj.add(thirdNode);
		linkedListObj.printNodes();

		try {
			INode searchNode = linkedListObj.search(30);
			System.out.println("Searched element is : " + searchNode.getKey());
			Assert.assertEquals(secondNode, searchNode);
		} catch (NullPointerException e) {
			System.out.println("Element not present in linked list");
		}
	}
}
