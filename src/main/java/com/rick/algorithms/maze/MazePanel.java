package com.rick.algorithms.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Rectangle;
import java.util.Stack;

import javax.swing.JPanel;


public class MazePanel extends JPanel implements KeyListener, MouseListener {
	private static final int SIZE = 50;
	public static final char OPEN = '0';
	public static final char CLOSE = '1';
	public static final char MARK = 'X';
	public static final char STEP = 'S';
	public static final char END = 'F';
	
	private MazeBoard frame;
	private char[][] srcMaze;
	private char[][] dstMaze;
	private Rectangle[][] pieces;
    // Keyboard states - Here are stored states for keyboard keys - is it down or not.
    private static boolean[] keyboardState = new boolean[525];	
	private boolean[][] flags = null;
	private Stack<Point> stack = null;
	private boolean isComplete = false;
	
    public static boolean keyboardKeyState(int key)
    {
        return keyboardState[key];
    }
    
	public MazePanel(MazeBoard board) {
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
		this.frame = board;
		this.addKeyListener(this);
		this.addMouseListener(this);
		initBoard();
	}
	
	private void initBoard() {
		this.srcMaze = createMaze();
		this.dstMaze = createMaze();
		int rows = dstMaze.length;
		int cols = dstMaze[0].length;
		this.pieces = new Rectangle[rows][cols];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				int x = j * SIZE;
				int y = i * SIZE;
				Rectangle r = new Rectangle(x, y, SIZE, SIZE);
				this.pieces[i][j] = r;			}
		}
		this.flags = new boolean[rows][cols];
		this.stack = new Stack<Point>();
		this.isComplete = false;
	}

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
//		System.out.println("23["+ s.charAt(23) + "],24[" + s.charAt(24) + "],25[" + s.charAt(25) + "]");
		while(pos < s.length())
		{
			char c = s.charAt(pos);
			
			if(c == OPEN || c == CLOSE || c == END)
			{
				if(column < 12)
				{
					maze[row][column] = c;
					column++;
				}
				else
				{
//					System.out.println("###[c]=" + c + ",row:" + row + ",column:" + column + ",pos:" + pos + ",s.length()=" + s.length());
					row++;
					column = 0;
					if(row < 12)
					{
						maze[row][column++] = c;
					}
					else
					{
						
						System.out.println("row:" + row + ",column:" + column + ",pos:" + pos + ",s.length()=" + s.length());
						break;
					}
					
				}
			}
			pos++;
		}
		return maze;
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		keyboardState[e.getKeyCode()] = true;
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
			if(maze[x][y] == END)
			{
//				System.out.println("Found End");
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
		return result;
	}	
	
	private void showPath()
	{
		Point start = new Point(2, 0);
		Point p = findPath(srcMaze, start);
		while(p != null)
		{
			dstMaze[p.row][p.column] = MARK;
			p = p.parent;
		}
	}
	
	private void markStep(Point p)
	{
		this.dstMaze[p.row][p.column] = MARK;
	}
	
	private void removeStep(Point p)
	{
//		this.dstMaze[p.row][p.column] = '0';
		this.dstMaze[p.row][p.column] = STEP;
	}
	
	private void nextStep()
	{
		if(isComplete)
		{
			return;
		}
		int rows = srcMaze.length;
		int columns = srcMaze[0].length;
		Point p = stack.pop();
		removeStep(p);
		
		int x = p.row;
		int y = p.column;
		Point child = null;
		if(srcMaze[x][y] == END)
		{
			dstMaze[x][y] = END;
			p = p.parent;
			while(p != null)
			{
//				dstMaze = createMaze();
				dstMaze[p.row][p.column] = 'X';
				p = p.parent;
			}
			while(stack.size() > 0)
			{
				Point remain = stack.pop();
				removeStep(remain);
			}
			isComplete = true;
			return;
//			System.out.println("Found End");
		}
		if(!flags[x][y])
		{
			x = p.row - 1;
			y = p.column;
			if(x >= 0 && (srcMaze[x][y] == OPEN ||srcMaze[x][y] == END ) && !flags[x][y])
			{
				child = new Point(x,y,p);
				stack.push(child);
				markStep(child);
			}

			x = p.row + 1;
			y = p.column;
			if(x < rows && (srcMaze[x][y] == OPEN || srcMaze[x][y] == END ) && !flags[x][y])
			{
				child = new Point(x,y,p);
				stack.push(child);
				markStep(child);
			}
			
			x = p.row;
			y = p.column - 1;
			if(y >= 0 && (srcMaze[x][y] == OPEN || srcMaze[x][y] == END ) && !flags[x][y])
			{
				child = new Point(x,y,p);
				stack.push(child);
				markStep(child);
			}
			
			x = p.row;
			y = p.column + 1;
			if(y < columns && (srcMaze[x][y] == OPEN || srcMaze[x][y] == END ) && !flags[x][y])
			{
				child = new Point(x,y,p);
				stack.push(child);
				markStep(child);
			}
							
			flags[p.row][p.column] = true;
		}		
	}
	
	public void keyReleased(KeyEvent e) {
        keyboardState[e.getKeyCode()] = false;
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            System.exit(0);
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
//        	initBoard();
        	if(!isComplete && stack.size() == 0)
        	{
        		Point start = new Point(2, 0);
        		stack.push(start);
        		markStep(start);
        	}
        	else
        	{
        		nextStep();
        	}
        	repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
        	initBoard();
        	repaint();
        }
	}

	private void printMaze(Graphics g)
	{
		int rows = dstMaze.length;
		int cols = dstMaze[0].length;
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				char c = dstMaze[i][j];
				Rectangle r = pieces[i][j];
				Graphics2D g2d = (Graphics2D)g; 
				if(c == OPEN)
				{
					g2d.setColor(Color.WHITE);
				}else if(c == CLOSE)
				{
					g2d.setColor(Color.BLACK);
				}else if(c == END)
				{
					g2d.setColor(Color.BLUE);
				}
				else if (c == MARK){
					g2d.setColor(Color.YELLOW);
				}
				else if (c == STEP){
					g2d.setColor(Color.PINK);
				}
				g2d.fill(r);
			}
		}
		
	}
	
	public void paint(Graphics g) {	
		printMaze(g);
		Graphics2D g2d = (Graphics2D)g; 
		g2d.setColor(Color.BLUE);
		g2d.drawString(" Help:", 600, 50);
		g2d.drawString("  Press SPACE to show next step", 600, 80);
		g2d.drawString("  Press Enter to reset", 600, 110);
		g2d.drawString("  Press ESC to exit game", 600, 140);
	}
}
