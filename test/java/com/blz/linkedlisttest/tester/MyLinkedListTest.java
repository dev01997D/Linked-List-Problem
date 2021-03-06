package com.blz.linkedlisttest.tester;

import static org.junit.Assert.assertEquals;

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

	@Test
	public void givenElementWhenInsertedAfterElementShouldPassLinkedListResult() {
		MyNode<Integer> firstNode = new MyNode<>(56);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(70);
		MyNode<Integer> insertNode = new MyNode<>(40);
		MyLinkedList linkedListObj = new MyLinkedList();

		linkedListObj.add(firstNode);
		linkedListObj.append(secondNode);
		linkedListObj.append(thirdNode);
		try {
			INode searchNode = linkedListObj.search(30);
			linkedListObj.insert(searchNode, insertNode);
			linkedListObj.printNodes();
			boolean result = secondNode.getNext().equals(insertNode) && insertNode.getNext().equals(thirdNode);
			Assert.assertTrue(result);
		} catch (NullPointerException e) {
			System.out.println("Insertion not happened because, Given key element is not present!");
		}
	}

	@Test
	public void givenElementWhenDeletedAfterElementShouldPassLinkedListResult() {
		MyNode<Integer> firstNode = new MyNode<>(56);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(70);
		MyNode<Integer> deleteNode = new MyNode<>(40);
		MyLinkedList linkedListObj = new MyLinkedList();

		linkedListObj.add(firstNode);
		linkedListObj.append(secondNode);
		linkedListObj.append(deleteNode);
		linkedListObj.append(thirdNode);
		linkedListObj.printNodes();
		try {
			INode searchNode = linkedListObj.search(secondNode.getKey());
			linkedListObj.removeNode(searchNode, deleteNode);
			System.out.println("Size of linkedlist after deletion is : " + linkedListObj.sizeOfLinkedList());
			linkedListObj.printNodes();
			boolean result = deleteNode.getNext().equals(thirdNode) && secondNode.getNext().equals(thirdNode);
			Assert.assertTrue(result);
		} catch (NullPointerException e) {
			System.out.println("Insertion not happened because, Given key element is not present!");
		}
	}

	@Test
	public void givenElementAddedInSortedShouldPassOrderedLinkedListResult() {
		MyNode<Integer> firstNode = new MyNode<>(30);
		MyNode<Integer> secondNode = new MyNode<>(40);
		MyNode<Integer> fourthNode = new MyNode<>(70);
		MyNode<Integer> thirdNode = new MyNode<>(56);

		MyLinkedList<Integer> linkedListObj = new MyLinkedList<Integer>();
		linkedListObj.insert(firstNode.getKey());
		linkedListObj.insert(fourthNode.getKey());
		linkedListObj.insert(thirdNode.getKey());
		linkedListObj.insert(secondNode.getKey());

		linkedListObj.printNodes();
		assertEquals(linkedListObj.head.getKey(), firstNode.getKey());
		boolean result = firstNode.getKey() <= secondNode.getKey() && secondNode.getKey() <= thirdNode.getKey();
		Assert.assertTrue(result);
	}
}
