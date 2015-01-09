package com.rick.algorithms.trietree;

import junit.framework.TestCase;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import com.rick.algorithms.util.Util;

public class DictionaryTest extends TestCase{
	private Dictionary dic;
	private final String FILE = "Dictionary_words.txt";
	
	public DictionaryTest() {

	}
	
	public void setUp() throws Exception
	{
		dic = new Dictionary();
	}
	
	public void testInsert()
	{
		String s = "play";
		int count = dic.insert(s);
		assertTrue(1 == count);
		assertTrue(1 == dic.getWordCount());
		assertTrue(4 == dic.getMaxWordLen());
		s = "player";
		count = dic.insert(s);
		assertTrue(2 == count);
		assertTrue(2 == dic.getWordCount());
		assertTrue(6 == dic.getMaxWordLen());
		s = "impossible";
		count = dic.insert(s);
		assertTrue(3 == count);
		assertTrue(3 == dic.getWordCount());
		assertTrue(10 == dic.getMaxWordLen());
		s = "abs";
		count = dic.insert(s);
		assertTrue(4 == count);
		assertTrue(4 == dic.getWordCount());
		assertTrue(10 == dic.getMaxWordLen());
		s = "zoo";
		count = dic.insert(s);
		assertTrue(5 == count);
		assertTrue(5 == dic.getWordCount());
		assertTrue(10 == dic.getMaxWordLen());
		
		Util.log(dic, "testInsert() success"); 
	}
	
//	public void testLoad()
//	{
//		long startTime = System.currentTimeMillis();
//		dic.load("words.txt");
//		long duration = System.currentTimeMillis() - startTime;
//		System.out.println("Load words.txt use: " + duration);
//		int count = dic.getWordCount();
//		System.out.println("count=" + count);
////		assertTrue(235886 == dic.getWordCount());
////		assertTrue(4 == dic.getMaxWordLen());
//	}
	
	private void printSet(Set<String> set)
	{
		StringBuilder sb = new StringBuilder();
		for(Iterator it = set.iterator(); it.hasNext();)
		{
			sb.append("[").append(it.next()).append("]");
		}
		Util.log("set=" + sb.toString());
	}
	
	public void testScanWordOne()
	{

		String[] inputs = {
				"play",
				"player",
				"go",
				"ergo",
				"lay",
				"ye",
				"erg",
				"layer",
				"yer",
				"er",
				"aye"
		};
		
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < inputs.length; i++)
		{
			dic.insert(inputs[i]);
		}
		
		String s = "kplayergo";
		dic.scanWord(set, s);
		printSet(set);
		assertTrue(set.size() == 11);
		for(int i = 0; i < inputs.length; i++)
		{
			assertTrue(set.contains(inputs[i]));
		}	
		Util.log(dic, "testScanWordOne() success"); 
	}
	
	public void testScanWord()
	{
		dic.load(FILE);
		String s = "TAMHAT";
		Set<String> set = new HashSet<String>();
		
//		set = dic.scanWord(s);
//		printSet(set);
//		System.out.println("set=" + set.size());
//		s = "rickplayer";
		s = "player";
		s = "abc";
		s = "abcd";
		s = "kplayergo";
		
		dic.scanWord(set, s);
		printSet(set);
		Util.log(dic, "testScanWord() success"); 
	}

}
