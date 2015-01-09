package com.rick.algorithms.maze;

public class Point{
	int row;
	int column;
	Point parent;
	public Point(int x, int y, Point p)
	{
		this.row = x;
		this.column = y;
		this.parent = p;
	}
	
	public Point(int x, int y)
	{
		this.row = x;
		this.column = y;			
	}
	
	public String toString()
	{
		return "{" + row + "," + column + "}";
	}
}
