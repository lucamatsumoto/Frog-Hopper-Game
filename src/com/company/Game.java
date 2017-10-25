package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Map;
import java.awt.FlowLayout;
import java.util.List;
public class Game {
    public static void startGame(List<Map<com.company.Coordinate, com.company.Hopper>> layouts )
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(5,5));
        com.company.Board board = new com.company.Board(boardPanel);
        board.setLayouts(layouts);
        board.paint();
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        com.company.Options options = new com.company.Options(optionsPanel, window, board);
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new FlowLayout());
        gamePanel.add(boardPanel);
        gamePanel.add(optionsPanel);
        window.getContentPane().add(gamePanel);
        window.setBounds(30,30, 600, 600 );
        window.setVisible(true);
    }
}