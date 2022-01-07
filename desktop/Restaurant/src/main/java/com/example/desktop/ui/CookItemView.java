package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CookItemView {

    private final JPanel panel;
    private final JLabel label;
    private final JButton button;

    public CookItemView() {
        panel = new JPanel( new FlowLayout(FlowLayout.LEFT));
        panel.setMinimumSize(new Dimension(300, 30));
        panel.setMaximumSize(new Dimension(300, 30));

        label = new JLabel();
        button = new JButton();
        button.setBounds(150, 1, 150, 24);

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        panel.setBorder(blackLine);
        panel.add(label);
        panel.add(button);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return button;
    }
}