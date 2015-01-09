package com.rick.algorithms.maze;

import java.util.Stack;
import com.rick.algorithms.util.Util;

public class Maze {

	public static final char OPEN = '0';
	public static final char CLOSE = '1';
	public static final char END = 'F';
	private boolean[][] flags = null;
	
	public Maze() {

	}
	
	public void printQueue(Stack<Point> s)
	{
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty())
		{
			Point p = s.pop();
			sb.append(p);
			System.out.println("printQueue " + p);
		}
		Util.log("Stack=" + sb.toString());
	}
	
	public void printPath(Point p, char[][] maze)
	{
		StringBuilder sb = new StringBuilder();
		Point t = p;
		while(t != null)
		{
//			System.out.println("printPath step: " + t);
			sb.append(t).append(",");
			maze[t.row][t.column] = 'X';
			t = t.parent;			
		}
		Util.printMaze(maze);
		Util.log("Path=" + sb.toString());
	}
	
	public Point findPath(char[][] maze, Point start)
	{
		if(null == maze){throw new IllegalArgumentException("maze can't be null");}
		int rows = maze.length;
		int columns = maze[0].length;
		flags = new boolean[rows][columns];
		Stack<Point> stack = new Stack<Point>();
		stack.push(start);
		Point result = null;
		
		while(!stack.isEmpty())
		{
			Point p = stack.pop();
			
			int x = p.row;
			int y = p.column;
//			System.out.println("queue.poll()=" + p + ",value=" + maze[x][y]);
			if(maze[x][y] == END)
			{
//				System.out.println("Found End");
//				printPath(p, maze);
				result = p;
				break;
			}
			if(!flags[x][y])
			{
				x = p.row - 1;
				y = p.column;
				if(x >= 0 && (maze[x][y] == OPEN ||maze[x][y] == END ) && !flags[x][y])
				{
					stack.push(new Point(x,y,p));
				}

				x = p.row + 1;
				y = p.column;
				if(x < rows && (maze[x][y] == OPEN ||maze[x][y] == END ) && !flags[x][y])
				{
					stack.push(new Point(x,y,p));
				}
				
				x = p.row;
				y = p.column - 1;
				if(y >= 0 && (maze[x][y] == OPEN ||maze[x][y] == END ) && !flags[x][y])
				{
					stack.push(new Point(x,y,p));
				}
				
				x = p.row;
				y = p.column + 1;
				if(y < columns && (maze[x][y] == OPEN ||maze[x][y] == END ) && !flags[x][y])
				{
					stack.push(new Point(x,y,p));
				}
								
				flags[p.row][p.column] = true;
			}

		}
//		printQueue(stack);
		return result;
	}

}
