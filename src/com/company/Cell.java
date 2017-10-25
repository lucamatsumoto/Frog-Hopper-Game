package com.company;

import java.awt.*;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.imageio.*;
import javax.swing.ImageIcon;
import java.io.IOException;

public class Cell extends JButton
{

    private JPanel panel;
    private com.company.Coordinate coordinate;
    private int size;
    private com.company.Hopper hopper;
    private com.company.Board board;

    public Cell(com.company.Board board, int x, int y, int size)
    {
        this.board = board;
        this.panel = board.getPanel();
        this.coordinate = com.company.Coordinate.get(x, y);
        this.size = size;
        this.hopper = com.company.Hopper.VACANT;
    }

    public void draw()
    {
        //g.translate(x * size, y * size);
        //g.drawRect(x*size, y*size , size, size);

        addActionListener(board);
        panel.add(this);
        setPreferredSize(new Dimension(100, 100));
        if(coordinate.getX()%2 == 0 && coordinate.getY()%2 == 0 || coordinate.getX()%2 == 1 && coordinate.getY()%2 == 1)
        {
            setEnabled(true);
            setText("O");
        }
        else
        {
            setEnabled(false);
        }

        setContentAreaFilled(true);
        //button.setOpaque(true);
        //button.setBorderPainted(false);
    }

    public com.company.Coordinate getCoordinate()
    {
        return coordinate;
    }

    public void setHopper(com.company.Hopper hopper)
    {
        this.hopper = hopper;
        if(hopper == com.company.Hopper.GREEN)
        {
            //setBackground(Color.GREEN);
            try {
                Image img = ImageIO.read(getClass().getResource("greenfrog.png"));
                setIcon(new ImageIcon(img));
            } catch (IOException ex) {
            }
        }
        else if(hopper == com.company.Hopper.RED)
        {
            //setBackground(Color.RED);
            try {
                Image img = ImageIO.read(getClass().getResource("redfrog.png"));
                setIcon(new ImageIcon(img));
            } catch (IOException ex) {
            }
        }
        if(hopper == com.company.Hopper.VACANT)
        {

            //g.fillOval(x*size + size/2 - 15, y*size + size/2 - 15, 30 , 30);
            //setBackground(null);
            setIcon(null);
            UIManager.getBorder("Button.border");
            //g.drawString("" + x + " , " + y, x*size + size/2, y*size + size/2);

        }
    }

    public com.company.Hopper getHopper()
    {
        return hopper;
    }
}