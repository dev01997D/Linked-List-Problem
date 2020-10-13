package com.blz.linkedlisttest.tester;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.blz.linkedlist.model.MyLinkedHashMap;

public class MyLinkedHashMapTest {
	@Test
	public void givenASentence_WhenAdded_ShouldReturnParanoidFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but"
				+ " because they keep putting themselves deliberately " + "into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		int frequency = myLinkedHashMap.get("paranoid");
		Assert.assertEquals(3, frequency);
	}
}
