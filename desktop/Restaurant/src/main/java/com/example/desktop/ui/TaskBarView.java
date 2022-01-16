package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TaskBarView {

    private final JPanel panel;
    private final JButton button1;
    private final JButton button2;

    public TaskBarView() {
        panel = new JPanel();
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        button1 = new JButton("Cooks");
        button2 = new JButton("Supply");


        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(800, 25));
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);

        button1.setBounds(1, 1, 100, 23);
        panel.add(button1);

        button2.setBounds(100, 1, 100, 23);
        panel.add(button2);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

}
