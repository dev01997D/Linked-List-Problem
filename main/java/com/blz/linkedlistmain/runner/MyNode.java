/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.blz.linkedlistmain.runner;

import com.blz.linkedlist.model.INode;

public class MyNode<T> implements INode<T> {
	private T key;
	private INode<T> next;

	// Parameterized Constructor
	public MyNode(T key) {
		this.key = key;
		this.next = null;
	}

	public INode<T> getNext() {
		return next;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	@Override
	public void setNext(INode<T> next) {
		this.next = next;
	}

}
