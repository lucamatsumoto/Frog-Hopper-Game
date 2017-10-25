package com.company;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HomePage implements ActionListener
{
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private JPanel panel;
    private JFrame window;

    private List<Map<com.company.Coordinate, com.company.Hopper>> easyLayouts = new ArrayList<>();
    private List<Map<com.company.Coordinate, com.company.Hopper>> mediumLayouts = new ArrayList<>();
    private List<Map<com.company.Coordinate, com.company.Hopper>> hardLayouts = new ArrayList<>();


    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch
                ( Throwable t)
        {
        }
        JPanel container = new JPanel();
        JLabel title = new JLabel("Hoppers: Peg Solitaire");
        title.setPreferredSize(new Dimension(600, 200));
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel level = new JLabel("Select difficulty");
        level.setFont(new Font("Serif", Font.PLAIN, 24));
        JFrame window2 = new JFrame();
        HomePage homePage = new HomePage();
        JPanel homePanel = homePage.createHomePanel();
        container.add(title);
        container.add(level);
        container.add(homePanel);
        window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window2.getContentPane().add(container);
        window2.setBounds(30,30, 600, 600 );
        window2.setVisible(true);
    }

    public JPanel createHomePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
        easy = new JButton("Easy");
        easy.setPreferredSize(new Dimension(100, 100));
        panel.add(easy);
        easy.addActionListener(this);
        medium = new JButton("Medium");
        medium.setPreferredSize(new Dimension(100, 100));
        panel.add(medium);
        medium.addActionListener(this);
        hard = new JButton("Hard");
        hard.setPreferredSize(new Dimension(100, 100));
        panel.add(hard);
        hard.addActionListener(this);
        return panel;
    }

    public HomePage()
    {
        Map<com.company.Coordinate, com.company.Hopper> layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.RED);
        easyLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.RED);
        easyLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.RED);
        easyLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 4), com.company.Hopper.RED);
        easyLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 4), com.company.Hopper.GREEN);
        easyLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 3), com.company.Hopper.RED);
        mediumLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(2, 4), com.company.Hopper.GREEN);
        mediumLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(4, 0), com.company.Hopper.GREEN);
        mediumLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(4, 0), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 3), com.company.Hopper.GREEN);
        mediumLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(3, 3), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 4), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.GREEN);
        mediumLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 4), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 3), com.company.Hopper.GREEN);
        hardLayouts.add(layout);


        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 4), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 3), com.company.Hopper.GREEN);
        hardLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 4), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 4), com.company.Hopper.GREEN);
        hardLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(0, 4), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 4), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.GREEN);
        hardLayouts.add(layout);

        layout = new HashMap<>();
        layout.put(com.company.Coordinate.get(0, 0), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(0, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(1, 1), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(3, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(2, 0), com.company.Hopper.RED);
        layout.put(com.company.Coordinate.get(1, 3), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 4), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 2), com.company.Hopper.GREEN);
        layout.put(com.company.Coordinate.get(4, 0), com.company.Hopper.GREEN);
        hardLayouts.add(layout);


    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == easy)
        {
            Collections.shuffle(easyLayouts);
            com.company.Game.startGame(easyLayouts);
            return;
        }
        else if(e.getSource() == medium)
        {
            Collections.shuffle(mediumLayouts);
            com.company.Game.startGame(mediumLayouts);
            return;
        }
        else if(e.getSource() == hard)
        {
            Collections.shuffle(hardLayouts);
            com.company.Game.startGame(hardLayouts);
            return;
        }
        window.dispose();
    }
}
