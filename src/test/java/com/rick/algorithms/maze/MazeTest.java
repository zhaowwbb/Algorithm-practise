package com.rick.algorithms.maze;

import junit.framework.TestCase;
import com.rick.algorithms.util.Util;

public class MazeTest extends TestCase {

	private int[][] results = {
			{5,6},{6,6},{7,6},{8,6},{8,5},{8,4},{7,4},{6,4},{5,4},{4,4},{4,3},{3,3},{2,3},{1,3},{1,2},{1,1},{2,1},{2,0}
	};
	
	private char[][] createMaze()
	{
		String s = 
				  "1 1 1 1 1 1 1 1 1 1 1 1" + 
				  "1 0 0 0 1 0 0 0 0 0 0 1" +
				  "0 0 1 0 1 0 1 1 1 1 0 1" +
				  "1 1 1 0 1 0 0 0 0 1 0 1" +
				  "1 0 0 0 0 1 1 1 0 1 0 1" +
				  "1 1 1 1 0 1 F 1 0 1 0 1" +
				  "1 0 0 1 0 1 0 1 0 1 0 1" +
				  "1 1 0 1 0 1 0 1 0 1 0 1" +
				  "1 0 0 0 0 0 0 0 0 1 0 1" +
				  "1 1 1 1 1 1 0 1 1 1 0 1" +
				  "1 0 0 0 0 0 0 1 0 0 0 1" +
				  "1 1 1 1 1 1 1 1 1 1 1 1";
		
		char[][] maze = new char[12][12]; 
		int pos = 0;
		int row = 0;
		int column = 0;

		while(pos < s.length())
		{
			char c = s.charAt(pos);
			
			if(c == Maze.OPEN || c == Maze.CLOSE || c == Maze.END)
			{
				if(column < 12)
				{
					maze[row][column] = c;
					column++;
				}
				else
				{
					row++;
					column = 0;
					if(row < 12)
					{
						maze[row][column++] = c;
					}
					else
					{						
						Util.log("row:" + row + ",column:" + column + ",pos:" + pos + ",s.length()=" + s.length());
						break;
					}
					
				}
			}
			pos++;
		}
		return maze;
	}
	
	public void testFindMazePathResult()
	{
		Maze m = new Maze();
		char[][] maze = createMaze();
		Util.printMaze(maze);
		Point start = new Point(2,0);
		Point p = m.findPath(maze, start);
		Point t = p;
		int i = 0;
		while(t != null)
		{
			int[] pos = results[i++];
			assertTrue(t.row == pos[0]);
			assertTrue(t.column == pos[1]);
			t = t.parent;	
		}
		
		m.printPath(p, maze);
		Util.log(m, "find maze path success");
	}

}
