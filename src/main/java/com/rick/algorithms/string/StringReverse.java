package com.rick.algorithms.string;

public class StringReverse {
	public String reverse(String str){
		System.out.println("source str=[" + str + "]");
		if(null == str)return null;
		StringBuilder sb = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--){
			sb.append(str.charAt(i));
		}
		System.out.println("reverse str=[" + sb.toString() + "]");
		return sb.toString();
	}
	
	public String recursiveReverse(String str){
		System.out.println("source str=[" + str + "]");
		if(null == str)return null;
		if(str.length() == 1)return str;
		return recursiveReverse(str.substring(1)) + str.charAt(0);
	}
}
