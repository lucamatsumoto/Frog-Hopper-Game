package com.company;

import java.awt.*;
import javax.swing.JPanel;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Stack;

public class Board implements ActionListener
{
    private JPanel panel;
    private Map<com.company.Coordinate, com.company.Cell> cellMap = new HashMap<>();
    private com.company.Cell firstSelect;
    private List<Map<com.company.Coordinate, com.company.Hopper>> layouts;
    private int currentLayout = 0;
    private Stack<com.company.Move> history = new Stack<>();

    public Board(JPanel panel)
    {
        this.panel = panel;
        this.panel.setPreferredSize(new Dimension(500, 500));
    }

    public void paint() {
        //g.drawRect (0, 0, 100, 100);
        for(int i = 0; i < 5; i++)
        {

            for(int j = 0; j < 5; j++)
            {
                com.company.Coordinate c= com.company.Coordinate.get(i, j);
                if(cellMap.containsKey(c))
                {
                    cellMap.get(c).draw();
                }
                else
                {
                    com.company.Cell cell =  new com.company.Cell(this, i, j, 100);
                    cell.draw();
                    cellMap.put(c, cell);
                }
                //cellMap.put(, cell);

            }
        }
        selectLayout();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof com.company.Cell)
        {
            com.company.Cell c = (com.company.Cell) e.getSource();
            boolean hasFirst = handleFirst(c);
            if(hasFirst == true)
            {
                boolean hasSecond = handleSecond(c);
                if(hasSecond)
                {
                    firstSelect.setBorder(UIManager.getBorder("Button.border"));
                    firstSelect = null;
                }
            }
            if(isGameOver())
            {
                if(currentLayout == layouts.size() - 1)
                {
                    JOptionPane.showMessageDialog(panel, "You have completed all of the layouts for this difficulty!", "Congratulations", JOptionPane.INFORMATION_MESSAGE, null);
                    return;
                }
                int option = JOptionPane.showConfirmDialog(panel, "Would you like to play again?", "Game Complete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION)
                {
                    history.clear();
                    currentLayout ++;
                    selectLayout();

                }

            }
            //System.out.println("x=" + c.getCoordinate().getX() + " , y=" + c.getCoordinate().getY());
        }
    }

    private boolean handleFirst(com.company.Cell c)
    {
        if(firstSelect == null && c.getHopper() == com.company.Hopper.VACANT)
        {
            return false;
        }
        if(firstSelect == null)
        {
            firstSelect = c;
            c.setBorder(new LineBorder(Color.black, 5));
            return true;
        }
        else if(firstSelect == c)
        {
            firstSelect = null;
            c.setBorder(UIManager.getBorder("Button.border"));
            return false;
        }
        return true;
    }

    private boolean handleSecond(com.company.Cell c)
    {
        if(c.getHopper() != com.company.Hopper.VACANT || firstSelect.getHopper() == com.company.Hopper.VACANT)
        {
            return false;
        }
        com.company.Cell first = firstSelect;
        com.company.Coordinate firstCoordinate = first.getCoordinate();
        com.company.Coordinate secondCoordinate = c.getCoordinate();
        int xDiff = Math.abs(firstCoordinate.getX() - secondCoordinate.getX());
        int yDiff = Math.abs(firstCoordinate.getY() - secondCoordinate.getY());
        com.company.Cell middle = null;
        if(xDiff == 2 && yDiff == 2)
        {
            middle = cellMap.get(com.company.Coordinate.get((firstCoordinate.getX() + secondCoordinate.getX())/2
                    , (firstCoordinate.getY() + secondCoordinate.getY())/2));
            //c.setBorder(new LineBorder(Color.black, 5));
            //return true;
        }

        else if(xDiff == 0 && yDiff == 4 )
        {
            middle = cellMap.get(com.company.Coordinate.get(firstCoordinate.getX()
                    , (firstCoordinate.getY() + secondCoordinate.getY())/2));
            //c.setBorder(new LineBorder(Color.black, 5));
            //return true;
        }
        else if(xDiff == 4 && yDiff == 0)
        {
            middle = cellMap.get(com.company.Coordinate.get((firstCoordinate.getX() + secondCoordinate.getX())/2
                    , firstCoordinate.getY()));
            //c.setBorder(new LineBorder(Color.black, 5));
            //return true;
        }
        else
        {
            return false;
        }
        if(middle == null || middle.getHopper() == com.company.Hopper.VACANT)
        {
            return false;
        }
        if(middle.getHopper() == com.company.Hopper.RED)
        {
            JOptionPane.showMessageDialog(panel, "You cannot hop over red frog", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        history.push(new com.company.Move(firstCoordinate, first.getHopper(), middle.getCoordinate(), middle.getHopper(), secondCoordinate, first.getHopper()));
        c.setHopper(first.getHopper());
        first.setHopper(com.company.Hopper.VACANT);
        middle.setHopper(com.company.Hopper.VACANT);

        if(!cellMap.containsKey(c.getCoordinate()))
        {
            cellMap.put(c.getCoordinate(), c);
        }
        return true;
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public void setLayouts(List<Map<com.company.Coordinate, com.company.Hopper>> layouts)
    {
        this.layouts = layouts;
    }

    public void selectLayout()
    {

        Map<com.company.Coordinate, com.company.Hopper> layout = layouts.get(currentLayout);

        for(int i = 0; i < 5; i++)
        {

            for(int j = 0; j < 5; j++)
            {
                com.company.Coordinate c= com.company.Coordinate.get(i, j);
                if(layout.containsKey(c))
                {
                    cellMap.get(c).setHopper(layout.get(c));
                }
                else
                {
                    cellMap.get(c).setHopper(com.company.Hopper.VACANT);
                }
                //cellMap.put(, cell);

            }
        }

    }

    public boolean isGameOver()
    {

        for(com.company.Cell c : cellMap.values())
        {
            if(c.getHopper() == com.company.Hopper.GREEN)
            {
                return false;
            }
        }
        return true;
    }

    public void undo()
    {
        if(history.empty() == false)
        {
            if(firstSelect != null)
            {
                firstSelect.setBorder(UIManager.getBorder("Button.border"));
                firstSelect = null;
            }
            com.company.Move move = history.pop();
            cellMap.get(move.getEndC()).setHopper(com.company.Hopper.VACANT);
            cellMap.get(move.getMiddleC()).setHopper(move.getMiddleH());
            cellMap.get(move.getFirstC()).setHopper(move.getEndH());
        }
    }
}

