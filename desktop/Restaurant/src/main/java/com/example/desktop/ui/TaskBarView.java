package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TaskBarView {

    private final JPanel panel;
    private final JButton button;

    public TaskBarView() {
        panel = new JPanel();
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        button = new JButton("Cooks");


        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(800, 25));
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);

        button.setBounds(1, 1, 100, 23);
        panel.add(button);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getButton() {
        return button;
    }

}
