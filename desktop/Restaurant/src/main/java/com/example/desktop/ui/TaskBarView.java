package com.example.desktop.ui;

//to jest ten poziomy pasek z Cooks i Recipes

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
//button na cooks
public class TaskBarView {

    private JPanel panelTop;
    private Border blackLine;
    private JButton button;

    public TaskBarView(){
        panelTop = new JPanel();
        blackLine = BorderFactory.createLineBorder(Color.black);
        button = new JButton("Cooks");

        //button.setBounds(1, 1, 100, 23);   ?
        panelTop.setBorder(blackLine);
        panelTop.setPreferredSize(new Dimension(800, 25));
        panelTop.setBackground(Color.GRAY);
        panelTop.setLayout(null);
    }

    public JPanel getPanelTop() {
        return panelTop;
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
