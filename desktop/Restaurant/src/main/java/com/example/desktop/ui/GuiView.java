package com.example.desktop.ui;

import com.example.desktop.controllers.TaskBarController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GuiView {

    private JFrame frame;
    private OrdersPlacedView ordersPlaced;
    private OrdersInProgressView ordersInProgress;
    private TaskBarView taskBar;
    private JPanel panel;

    private Border blackLine;

    public GuiView(){
        frame = new JFrame("Kitchen application");
        taskBar = new TaskBarView();
        ordersPlaced = new OrdersPlacedView();
        ordersInProgress = new OrdersInProgressView();
        blackLine = BorderFactory.createLineBorder(Color.black);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setPreferredSize(new Dimension(800, 400));
        panel.add(ordersPlaced.getPanel());
        panel.add(ordersInProgress.getPanel());

        frame.setPreferredSize(new Dimension(800, 450));
        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(true);
//        frame.setLayout(new GridLayout(1, 2));

        frame.add(taskBar.getPanel(), BorderLayout.NORTH);
//        frame.add(ordersPlaced.getPanel(), BorderLayout.LINE_START);
//        frame.add(ordersInProgress.getPanel(), BorderLayout.LINE_END);
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public OrdersPlacedView getPanelLeft(){
        return ordersPlaced;
    }

    public OrdersInProgressView getPanelRight() {
        return ordersInProgress;
    }

    public TaskBarView getPanelTop() {
        return taskBar;
    }

    public Border getBlackLine() {
        return blackLine;
    }
}
