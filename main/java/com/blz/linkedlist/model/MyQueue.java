package com.blz.linkedlist.model;

public class MyQueue {
	private final MyLinkedList myLinkedList;
	
	public MyQueue() {
		this.myLinkedList = new MyLinkedList();
	}
	public void enQueue(INode myNode) {
		myLinkedList.append(myNode);
	}
	public void printQueue() {
		myLinkedList.printNodes();
	}
	public INode peak() {
		return myLinkedList.tail;
	}
}
