package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Options implements ActionListener
{
    private JPanel panel;
    private JButton undo;
    private JFrame window;
    private JButton returnButton;
    private JButton help;
    private com.company.Board board;

    public Options(JPanel panel, JFrame window, com.company.Board board)
    {
        this.panel = panel;
        undo = new JButton("Undo");
        this.panel.add(undo);
        undo.addActionListener(this);
        this.window = window;
        returnButton = new JButton("Return to homepage");
        this.panel.add(returnButton);
        returnButton.addActionListener(this);
        help = new JButton("Instructions/Help");
        this.panel.add(help);
        help.addActionListener(this);
        this.board = board;

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == help)
        {

            String message =
                    "Instructions\n" +
                            "\n"+
                            "Objective: Jump till only the red frog is left\n" +
                            "\n"+
                            "The Rules:\n" +
                            "1. Frogs move from tile to tile only when there is one frog in between the first and final destination\n" +
                            "2. You may only move by jumping over another frog on an adjacent tile, and landing on the next tile\n" +
                            "3. When a frog is jumped over, it will be removed from the board\n" +
                            "4. You cannot jump over a red tile.\n" +
                            "5. No non-jump moves are allowed. Frogs cannot jump over an empty tile. No frog may\n" +
                            "land on another frog. No frog may jump over two tiles at a time.\n" +
                            "6. The challenge is solved when only the red tile is left on the board\n"+
                            "\n" +
                            "How to play\n"+
                            "Click on the frog that you would like to move, then click the place you want to move it to.\n"+
                            "The frog that is hopped over will be removed from the board.\n" +
                            "Click on the bolded tile twice to cancel your pick.\n";


            JOptionPane.showMessageDialog(panel, message, "Instructions", JOptionPane.INFORMATION_MESSAGE, null);
        }

        if(e.getSource() == undo)
        {
            board.undo();
            return;
        }

        if(e.getSource() != returnButton)
        {
            return;
        }

        window.dispose();
    }

}

