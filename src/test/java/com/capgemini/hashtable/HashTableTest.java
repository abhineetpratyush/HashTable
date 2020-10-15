package com.capgemini.hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {
	private static final Logger log = LogManager.getLogger(HashTableTest.class);
	@Test
	public void givenASentence_WhenWordsAreAddedToList_ShouldReturnParanoidFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but"
				+ " because they keep putting themselves deliberately into paranoid "
				+ "avoidable situations";
		MyHashTable<String, Integer> myHashTable = new MyHashTable<>();
		String[] words = sentence.toLowerCase().split(" ");
		for(String word : words) {
			Integer value =  myHashTable.get(word);
			if(value == null)
				value = 1;
			else 
				value = value + 1;
			myHashTable.add(word, value);
		}
		log.info(myHashTable);
		int frequency = myHashTable.get("paranoid");
		Assert.assertEquals(3, frequency);
	}
}
