package com.blz.linkedlist.model;

import java.util.LinkedList;

import com.blz.linkedlistmain.runner.MyNode;

public class MyLinkedList<K> {
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
	public void append(INode<K> myNode) {
		if (this.head == null)
			this.head = myNode;
		if (this.tail == null)
			this.tail = myNode;
		else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	// Inserting the node between two nodes
	public void insert(INode myNode, INode newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	// Method to search for a key inLinked List
	public INode search(K key) {
		INode tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key))
				return tempNode;
			else
				tempNode = tempNode.getNext();
		}
		return null;
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

	// Method to return size of LinkedList
	public int sizeOfLinkedList() {
		int size = 0;
		INode tempNode = this.head;
		while (tempNode.getNext() != null) {
			size++;
			tempNode = tempNode.getNext();

		}
		return size;
	}

	// Method to remove a given Node from LinkedList
	public void removeNode(INode myNode, INode deleteNode) {
		myNode.setNext(deleteNode.getNext());
	}

	// ADDING NEW NODE INTO THE LIST IN SORTED ORDER
	public <T extends Comparable<T>> void insert(T key) {
		MyNode newNode = new MyNode(key);
		INode<T> current = head;
		INode previous = null;
		while (current != null && key.compareTo(current.getKey()) > 0) {
			previous = current;
			current = current.getNext();
		}
		// insertion at beginning of the list
		if (previous == null) {
			head = newNode;
		} else {
			previous.setNext(newNode);
		}
		newNode.setNext(current);
	}

	@Override
	public String toString() {
		return "MyLinkedListNodes {head=" + head + "}";
	}
}
