package com.blz.linkedlist.model;

import com.blz.linkedlistmain.runner.MyNode;

public class MyLinkedList<T> {
	public INode head;
	public INode tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Adding a node to top
	public void add(INode newNode) {
		if (this.tail == null)
			this.tail = newNode;
		if (this.head == null)
			this.head = newNode;
		else {
			INode tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}

	// Printing the available nodes
	public void printNodes() {
		StringBuffer myNodes = new StringBuffer("My Nodes : ");
		INode tempNode = this.head;
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(tail))
				myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}

	// Appending nodes at last
	public void append(INode myNode) {
		if (this.head == null)
			this.head = myNode;
		if (this.tail == null)
			this.tail = myNode;
		else {
			INode tempNode = this.tail;
			this.tail = myNode;
			tempNode.setNext(myNode);
		}
	}

//	Inserting the node between two nodes
	public void insert(INode myNode, INode newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	// Pop method to remove first element of Linked List
	public INode pop() {
		INode tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	// PopLast method to remove last element of Linked List
	public INode popLast() {
		INode tempNode = head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		return tempNode;
	}

	// Method to search for a key inLinked List
	public INode search(T key) {
		INode tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey() == key)
				break;
			tempNode = tempNode.getNext();
		}
		if (tempNode.getKey() == key)
			return tempNode;
		else
			return null;
	}
}
