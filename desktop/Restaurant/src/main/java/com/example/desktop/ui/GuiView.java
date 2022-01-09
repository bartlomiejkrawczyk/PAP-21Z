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

    private Border blackLine;

    public GuiView(){
        frame = new JFrame("Kitchen application");
        taskBar = new TaskBarView();
        ordersPlaced = new OrdersPlacedView();
        ordersInProgress = new OrdersInProgressView();
        blackLine = BorderFactory.createLineBorder(Color.black);

        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(true);

        frame.add(taskBar.getPanel(), BorderLayout.NORTH);
        frame.add(ordersPlaced.getPanel(), BorderLayout.LINE_START);
        frame.add(ordersInProgress.getPanel(), BorderLayout.LINE_END);

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
