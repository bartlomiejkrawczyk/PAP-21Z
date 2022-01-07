package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OrdersInProgressItemView {

    private JPanel orderPanel;
    private JLabel dishLabel;
    private JButton assignButton;
    private JButton detailsButton;

    public OrdersInProgressItemView(){

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        orderPanel = new JPanel();
        orderPanel.setBorder(blackLine);
        orderPanel.setPreferredSize(new Dimension(200, 28));
        orderPanel.setLayout(null);

        dishLabel = new JLabel();
        dishLabel.setBounds(25, 0, 250, 28);

        assignButton = new JButton("Done");
        assignButton.setBounds(200, 0, 90, 28);

        detailsButton = new JButton("Details");
        detailsButton.setBounds(290, 0, 90, 28);

        orderPanel.add(dishLabel);
        orderPanel.add(assignButton);
        orderPanel.add(detailsButton);
    }

    public JPanel getOrderPanel() {
        return orderPanel;
    }

    public JLabel getDishLabel() {
        return dishLabel;
    }

    public JButton getAssignButton() {
        return assignButton;
    }

    public JButton getDetailsButton() {
        return detailsButton;
    }
}
