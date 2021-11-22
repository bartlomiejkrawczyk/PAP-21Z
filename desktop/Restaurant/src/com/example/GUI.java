package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    int greetingsButtonCounter = 0;

    private JPanel panel = new JPanel();
    private JButton greetingButton = new JButton("Hello World!");
    private JButton exitButton = new JButton("Goodbye World!");
    private JLabel helloCounter = new JLabel("Hellos: " + greetingsButtonCounter, SwingConstants.CENTER);

    public GUI() {

        JFrame frame = new JFrame("Hello World Java Swing");
        frame.setMinimumSize(new Dimension(480, 270));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout());

        greetingButton.addActionListener(countHellos);
        exitButton.addActionListener(exit);
        greetingButton.setPreferredSize(new Dimension(160, 90));

        panel.add(greetingButton);
        panel.add(exitButton);
        panel.add(helloCounter);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }

    ActionListener exit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

    ActionListener countHellos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            greetingsButtonCounter++;
            helloCounter.setText("Hellos: " + greetingsButtonCounter);
        }
    };

}