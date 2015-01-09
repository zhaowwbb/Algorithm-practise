package com.rick.algorithms.trietree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class WordSearchUtility {
	private Dictionary dic = null;
	
	public WordSearchUtility() {
		dic = new Dictionary();
	}
	
	public void loadDictionary()
	{
		dic.load(Constant.DICTIONARY_FILE);
	}

	public static void help()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Usage:\n");
		sb.append("   java -jar WordSearchUtility.jar [input file]\n");
		sb.append("Sample:   \n");
		sb.append("   java -jar WordSearchUtility.jar abc.txt     \n");
		System.out.println(sb.toString());
	}
	
	public boolean isValid(String s, int row, int colomns)
	{
		if(row != 0 && s.length() != colomns)
		{
			System.err.println("[ERROR] line " + row + ", string length does not match with other row, expect: " + colomns + ", actual:" + s.length());
			return false;
		}
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if((c >= Constant.LOWER_CASE_START && c <= Constant.LOWER_CASE_END) ||
				(c >= Constant.UPPER_CASE_START && c <= Constant.UPPER_CASE_END)
				)
			{
				
			}
			else
			{
				System.err.println("[ERROR] line " + row + ", column " + (i+1) + " has invalid character " + c + ", only allow [a-z] or [A-Z]");
				return false;
			}
		}
		return true;
	}	
	
	private char[][] createArray(List<String> list)
	{
		int rows = list.size();
		int columns = list.get(0).length();
		char[][] array = new char[rows][columns];
		for(int i = 0; i < list.size(); i++)
		{
			String s = list.get(i);
			for(int j = 0; j < columns; j++)
			{
				array[i][j] = s.charAt(j);
			}
		}
		return array;
	}
	
	public void calculateRows(Set<String> set, List<String> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			String str = list.get(i);
			dic.scanWord(set, str);
			String reverseStr = new StringBuffer(str).reverse().toString();
			dic.scanWord(set, reverseStr);
		}
	}

	public void calculateColumns(Set<String> set, char[][] array)
	{
		
		for(int i = 0; i < array[0].length; i++)
		{
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < array.length; j++)
			{
				sb.append(array[j][i]);
			}
			String str = sb.toString();
			dic.scanWord(set, str);
			String reverse = sb.reverse().toString();
			dic.scanWord(set, reverse);
		}
	}	

	public void calculateDiagonals(Set<String> set, char[][] array)
	{
		int rows = array.length;
		int columns = array[0].length;
		int i = 0;
		while(i < columns)
		{
			StringBuffer sb = new StringBuffer();
			int j = 0;
			int pos = i;
			while(j < rows && pos < columns)
			{
				sb.append(array[j++][pos++]);
			}
			
			String str = sb.toString();
			dic.scanWord(set, str);
			String reverse = sb.reverse().toString();
			dic.scanWord(set, reverse);			
			i++;
		}
		
		i = 1;
		while(i < rows)
		{
			StringBuffer sb = new StringBuffer();
			int j = 0;
			int pos = i;
			while(j < columns && pos < rows)
			{
				sb.append(array[pos++][j++]);
			}	
			String str = sb.toString();
			dic.scanWord(set, str);
			String reverse = sb.reverse().toString();
			dic.scanWord(set, reverse);			
			i++;
		}

	}
	
	public List<String> loadInput(String inputFile)
	{
		BufferedReader br = null;
		int count = 0;
		int columns = 0;
		List<String> list = new ArrayList<String>();
		try
		{
			br = new BufferedReader(new FileReader(inputFile));				
			System.out.println("Loading input file: " + inputFile);
			String line = br.readLine();
			while(line != null)
			{
				if(count == 0)
				{
					columns = line.length();
				}
				count++;
				if(isValid(line, count, columns))
				{					
					list.add(line);
				}
				else
				{
					throw new IllegalArgumentException("Invalid input data");
				}
				
				line = br.readLine();				
			}
			System.out.println("Input file loading is completed.");
		}
		catch(FileNotFoundException e)
		{
			System.err.println("[ERROR] Input file [" + inputFile + "] not found");
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
		return list;
	}	
	
	public void writeToFile(Set<String> set)
	{
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(Constant.OUTPUT_FILE), "utf-8"));
		    for(Iterator it = set.iterator(); it.hasNext();)
		    {
		    	writer.write((String)it.next());
		    	writer.write("\n");
		    }
		    writer.flush();
		    System.out.println("Word search is completed, found words can be found in " + Constant.OUTPUT_FILE);
		} catch (IOException ex) {
			System.err.println("[ERROR] write to file failed: " + ex);
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	}
	
	private void printStatistics()
	{
		System.out.println("Total dictionary lookup: " + dic.getCount());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordSearchUtility ws = new WordSearchUtility();
		if(args.length != 1)
		{
			help();
			return;
		}
		String inputFile = args[0];
		
		ws.loadDictionary();
		List<String> list = ws.loadInput(inputFile);
		char[][] array = ws.createArray(list);
		Set<String> set = new HashSet<String>();
		long start = System.currentTimeMillis();
		ws.calculateRows(set, list);
		ws.calculateColumns(set, array);
		ws.calculateDiagonals(set, array);
		long duration = System.currentTimeMillis() - start;
		ws.printStatistics();
		System.out.println("Search operation takes:" + duration + " milliseconds");
		System.out.println("Found words count: " + set.size());
		ws.writeToFile(set);
//		System.out.println("Write to file complete");
	}

}

