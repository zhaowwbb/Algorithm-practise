package com.rick.algorithms.util;

import java.util.List;

public class Util {

	public static void printList(List list, String prefix)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++)
		{
			sb.append("[").append(list.get(i)).append("]");
		}
		log(prefix + "=" + sb.toString());
	}
	
	public static void log(String s)
	{
		System.out.println(s);
	}
	
	public static void log(Object o, String str)
	{
		log(o.getClass().getName() + ": " + str);
	}

	public static void printMaze(char[][] arrays)
	{
		log("Print Maze():");
		for(int i = 0; i < arrays.length; i++)
		{
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < arrays[i].length; j++)
			{
				sb.append(arrays[i][j]).append(' ');
			}
			log(sb.toString());
		}
	}
	
	public static void printMatrix(int[][] matrix)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				sb.append(matrix[i][j]).append("\t");
			}
			sb.append("\n");
		}
		log("Matrix:");
		log(sb.toString());		
	}
}
