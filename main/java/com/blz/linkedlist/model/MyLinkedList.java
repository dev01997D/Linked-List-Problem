package com.blz.linkedlist.model;

import com.blz.linkedlistmain.runner.MyNode;

public class MyLinkedList {
	public INode head;
	public INode tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	//Adding a node
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

	//Printing the available nodes
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
}
