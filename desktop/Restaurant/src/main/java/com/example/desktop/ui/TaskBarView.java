package com.example.desktop.ui;

//to jest ten poziomy pasek z Cooks i Recipes

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
//button na cooks
public class TaskBarView {

    private JPanel panel;
    private Border blackLine;
    private JButton button;

    public TaskBarView(){
        panel = new JPanel();
        blackLine = BorderFactory.createLineBorder(Color.black);
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

    public Border getBlackLine() {
        return blackLine;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}
