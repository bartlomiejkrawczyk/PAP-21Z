package com.example.desktop.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Class creating and facilitating view of whole frame enabling us to
 * see basic GUI.
 */
public class GuiView {

    private final OrdersPlacedView ordersPlaced;
    private final OrdersInProgressView ordersInProgress;
    private final TaskBarView taskBar;
    private final JPanel panel;

    public GuiView() {
        JFrame frame = new JFrame("Kitchen application");
        taskBar = new TaskBarView();
        ordersPlaced = new OrdersPlacedView();
        ordersInProgress = new OrdersInProgressView();

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setPreferredSize(new Dimension(800, 400));
        panel.add(ordersPlaced.getPanel());
        panel.add(ordersInProgress.getPanel());

        frame.setPreferredSize(new Dimension(800, 450));
        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(true);

        frame.add(taskBar.getPanel(), BorderLayout.NORTH);
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public OrdersPlacedView getPanelLeft() {
        return ordersPlaced;
    }

    public OrdersInProgressView getPanelRight() {
        return ordersInProgress;
    }

    public TaskBarView getPanelTop() {
        return taskBar;
    }

    public JPanel getPanel() {
        return panel;
    }
}
