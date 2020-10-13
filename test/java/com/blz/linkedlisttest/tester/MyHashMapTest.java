package com.blz.linkedlisttest.tester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blz.linkedlist.model.MyHashMap;

import junit.framework.Assert;

public class MyHashMapTest {

	@Test
	public void givenASentence_WhenAdded_ShouldReturnFrequencyOfEachWord() {
		String sentence = "To be or not to be";
		MyHashMap<String, Integer> myHashMap = new MyHashMap();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myHashMap.add(word, value);
		}
		int frequency = myHashMap.get("to");
		assertEquals(2, frequency);
	}
}

