package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CooksView {

    private JFrame frameCooks;
    private JPanel panelCooks;
    private JPanel panelTitle;
    private JLabel labelTitle;
    private JPanel scrollableCooks;
    private JScrollPane scrollCooks;

    public CooksView() {
        frameCooks = new JFrame("Cooks");
        // Set frame sizes
        frameCooks.setMinimumSize(new Dimension(300, 300));
        frameCooks.setResizable(false);
        frameCooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create UI elements
        panelCooks = new JPanel();
        panelTitle = new JPanel();
        labelTitle = new JLabel("Cooks: ");
        scrollableCooks = new JPanel();
        scrollCooks = new JScrollPane(scrollableCooks);

        // Add UI element to frame
        scrollCooks.setPreferredSize(new Dimension(300, 240));
        scrollableCooks.setLayout(new BoxLayout(scrollableCooks, BoxLayout.Y_AXIS));
        scrollableCooks.setAutoscrolls(true);

        panelTitle.setBackground(Color.DARK_GRAY);
        panelTitle.setBounds(1, 1, 300, 30);
        labelTitle.setForeground(Color.WHITE);
        panelTitle.add(labelTitle);
        panelCooks.add(panelTitle);
        panelCooks.add(scrollCooks);


        Border blackLine = BorderFactory.createLineBorder(Color.black);

        panelCooks.setBorder(blackLine);
        panelCooks.setPreferredSize(new Dimension(300, 30));
        panelCooks.setLayout(new BoxLayout(panelCooks, BoxLayout.Y_AXIS));

        frameCooks.add(panelCooks, BorderLayout.LINE_START);

        frameCooks.pack();
        frameCooks.setLocationRelativeTo(null);
        frameCooks.setVisible(true);

    }


    public static void main(String[] args) {
        new CooksView();
    }

    public JFrame getFrameCooks() {
        return frameCooks;
    }

    public void setFrameCooks(JFrame frameCooks) {
        this.frameCooks = frameCooks;
    }

    public JPanel getPanelCooks() {
        return panelCooks;
    }

    public void setPanelCooks(JPanel panelCooks) {
        this.panelCooks = panelCooks;
    }

    public JPanel getPanelTitle() {
        return panelTitle;
    }

    public void setPanelTitle(JPanel panelTitle) {
        this.panelTitle = panelTitle;
    }

    public JLabel getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(JLabel labelTitle) {
        this.labelTitle = labelTitle;
    }

    public JPanel getScrollableCooks() {
        return scrollableCooks;
    }

    public void setScrollableCooks(JPanel scrollableCooks) {
        this.scrollableCooks = scrollableCooks;
    }

    public JScrollPane getScrollCooks() {
        return scrollCooks;
    }

    public void setScrollCooks(JScrollPane scrollCooks) {
        this.scrollCooks = scrollCooks;
    }
}
