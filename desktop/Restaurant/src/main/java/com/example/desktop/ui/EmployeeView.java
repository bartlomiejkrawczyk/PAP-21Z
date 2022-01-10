package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class EmployeeView {

    private final JPanel panel;
    private final JLabel label;

    public EmployeeView() {

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        panel = new JPanel();
        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(200, 50));
        panel.setMaximumSize(new Dimension(5000, 50));
        panel.setMinimumSize(new Dimension(100, 50));
        panel.setBackground(Color.lightGray);

        panel.setLayout(null);

        label = new JLabel();
        label.setBounds(100, 0, 250, 50);
        label.setForeground(Color.black);

        panel.add(label);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLabel() {
        return label;
    }
}


