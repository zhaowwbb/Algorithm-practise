package com.rick.algorithms.trietree;

public class Node {   
	private String value;
	private boolean isWord;
	private Node[] nodes;
	
	public Node(String s) {
		this.value = s;
		this.nodes = new Node[Constant.CHILDREN_SIZE];
		this.isWord = false;
	}

	public String getValue()
	{
		return this.value;
	}
	
	public boolean isWord()
	{
		return this.isWord;
	}
	
	public void setIsWord(boolean b)
	{
		this.isWord = b;
	}
	
	/**
	 * Calculate child node array index for input letter
	 * @param c The input letter
	 * @return The position of that letter in array, -1 for invalid input
	 */
	private int getPos(char c)
	{
		int pos = Constant.INVALID_POS;
		if(c <= Constant.LOWER_CASE_END && c >= Constant.LOWER_CASE_START)
		{
			pos = c - Constant.LOWER_CASE_START;
		}
		if(c <= Constant.UPPER_CASE_END && c >= Constant.UPPER_CASE_START)
		{
			pos = c - Constant.UPPER_CASE_START;
		}	
		return pos;
	}
	
	public Node getChild(char c)
	{
		int pos = getPos(c);
		if(Constant.INVALID_POS == pos)
		{
			return null;
		}
		return nodes[pos];
	}
	
	public void setChild(char c, Node n)
	{
		int pos = getPos(c);
		if(Constant.INVALID_POS != pos)
		{
			nodes[pos] = n;
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[value=").append(this.value);
		sb.append(",isWord=").append(this.isWord);
		sb.append(",nodes=").append(nodes).append("]");
		return sb.toString();
	}
}
