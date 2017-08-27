package com.rick.algorithms.string;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class FindNonRepeatedChar {

	public String findNonRepeatedChar1(String input) {
		System.out.println("findNonRepeatedChar1()");
		if(null == input)return null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			String key = String.valueOf(c);
			Integer count = map.get(key);
			if(null == count) {
				count = new Integer(1);
			}else {
				count = count.intValue() + 1;
			}
			map.put(key, count);
		}

		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			String key = String.valueOf(c);
			Integer count = map.get(key);
			if(1 == count.intValue()) {
				printStr(input, i, key);
				return key;
			}
		}
		
		return null;
	}
	
	public void printStr(String input, int pos, String key) {
		StringBuilder sb = new StringBuilder();
		sb.append("String=[").append(input).append("],");
		sb.append("pos[").append(pos).append("]=[").append(key).append("]");
		System.out.println(sb.toString());		
	}
	
	public String findNonRepeatedChar2(String input) {
		System.out.println("findNonRepeatedChar2()");
		if(null == input)return null;
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			String key = String.valueOf(c);
			if(input.indexOf(c) == input.lastIndexOf(c)) {
				printStr(input, i, key);
				return String.valueOf(c);
			}
		}
		return null;
	}
	
	public String findNonRepeatedChar3(String input) {
		System.out.println("findNonRepeatedChar3()");
		if(null == input)return null;
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < input.length(); i++) {
			char left = input.charAt(i);
			if(set.contains(left)) {
				//repeated
				continue;
			}
			
			String key = String.valueOf(left);
			boolean isNonRepeated = true;
			for(int j = input.length() - 1; j >= 0 && isNonRepeated; j--) {
				char right = input.charAt(j);
				if(left == right) {
					if(i == j) {
						printStr(input, i, key);
						return String.valueOf(left);						
					}else {
						set.add(Character.valueOf(left));
						isNonRepeated = false;
					}
				}
				
//				if(i == j && left == right) {
//					printStr(input, i, key);
//					return String.valueOf(left);
//				}
			}
		}
		return null;
	}	
	
	public void verify(String key1, String key2) {
		if(key1.equals("t")) {
			System.out.println("Test 1 [OK]");
		}else {
			System.out.println("Test 1 [Failed]");
		}		

		if(key2.equals("r")) {
			System.out.println("Test 2 [OK]");
		}else {
			System.out.println("Test 2 [Failed]");
		}		
	}
	
	public void test() {
		String input1 = "stress";
		String input2 = "teeter";

		String key1 = null;
		String key2 = null;
		
		key1 = findNonRepeatedChar1(input1);
		key2 = findNonRepeatedChar1(input2);
		verify(key1, key2);

		key1 = findNonRepeatedChar2(input1);
		key2 = findNonRepeatedChar2(input2);
		verify(key1, key2);
		
		key1 = findNonRepeatedChar3(input1);
		key2 = findNonRepeatedChar3(input2);	
		verify(key1, key2);
	}
	
	public static void main(String[] args) {
		FindNonRepeatedChar f = new FindNonRepeatedChar();		
		f.test();
	}

}
