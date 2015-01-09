package com.rick.algorithms.trietree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Set;

public class Dictionary {

	private int wordCount;
	private int maxWordLen;
	private Node root;
	private int counter;
		
	public Dictionary() {
		this.wordCount = 0;
		this.maxWordLen = 0;
		this.root = new Node(" ");
		this.counter = 0;
	}

	public void load(String wordFile)
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(wordFile));	
			String line = br.readLine();
			System.out.println("Loading Dictionary file: " + wordFile);
			while(line != null)
			{
				insert(line);
				line = br.readLine();
			}
			System.out.println("Loading Dictionary file is completed.");
			System.out.println("Max word length: " + maxWordLen);
		}
		catch(FileNotFoundException e)
		{
			System.err.println("[ERROR] File [" + wordFile + "] not found");
		}
		catch(IOException ex)
		{
			System.err.println("[ERROR] " + ex);			
		}
		finally
		{
			if(br != null)
			{
				try{
					br.close();
				}catch(IOException e)
				{
					System.err.println("[ERROR] " + e.toString());
				}
			}
		}
	}
	
	/**
	 * Insert word into dictionary, it's not a case sensitive operation,
	 * for example, "Tuba" and "tuba" will be considered as one word, not two
	 * @param s the new word to be inserted into dictionary
	 * @return the total number of the word in dictionary
	 */
	public int insert(String s)
	{
		Node n = root;
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			Node child = n.getChild(c);
			if(null == child)
			{
				child = new Node(s.substring(0, i + 1));
				n.setChild(c, child);
			}
			n = child;
		}
		if(n != root)
		{
			if(!n.isWord())
			{
				n.setIsWord(true);
				if(s.length() > maxWordLen)
				{
					maxWordLen = s.length();
				}
				this.wordCount++;
			}
			else
			{
//				System.out.println("Found duplicate=[" + s + "]");
			}
		}
		return this.wordCount;
	}
	
	public int getMaxWordLen()
	{
		return this.maxWordLen;
	}
	
	public int getWordCount()
	{
		return this.wordCount;
	}
	
	public Node findWord(String s)
	{
		this.counter++;
		Node n = root;
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			Node child = n.getChild(c);
			if(null == child)return null;
			n = child;
		}
		if(n != root)return n;
		return null;
	}
	
	public void scanWord(Set<String> set, String s)
	{
		if(null == s)return;
		int start = 0;
		int end = s.length();
		int pos = 0;
		Node n = root;
//		System.out.println("Scan:[" + s + "]");
		while(start < end)
		{

			if(start + pos < end)
			{
				String str = s.substring(start, start + pos + 1);
				
//				//If sub string length is greater than the maximum word length in dictionary, skip it
//				if(str.length() > maxWordLen)
//				{
//					start++;
//					pos = 0;
//				}
//				else
//				{
					Node child = findWord(str);
					if(null == child)
					{
						start++;
						pos = 0;
					}
					else
					{
						n = child;
						pos++;
						if(n.isWord())
						{
							set.add(n.getValue());
						}
					}				
//				}				
			}
			else
			{
				start++;
				pos = 0;
			}
		}
	}
	
	public int getCount()
	{
		return this.counter;
	}
}
