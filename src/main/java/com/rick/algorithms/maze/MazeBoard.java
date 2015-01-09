package com.rick.algorithms.maze;

import javax.swing.JFrame;

//import chess.Board;
//import chess.Chess;

public class MazeBoard extends JFrame{

	public MazeBoard() {
        add(new MazePanel(this));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Maze");
        setResizable(false);
        setVisible(true);
	}

    public static void main(String[] args) {
        new MazeBoard();
    }
}
