package com.blz.linkedlist.model;

import com.blz.linkedlistmain.runner.MyNode;

public class MyLinkedList {
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
		INode tempNode=myNode.getNext();
		head.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode pop() {
		INode tempNode=this.head;
		this.head=head.getNext();
		return tempNode;
	}
}
