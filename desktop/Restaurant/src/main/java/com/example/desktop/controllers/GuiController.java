package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.ui.GuiView;

import javax.swing.*;

/**
 * Class responsible for controlling whole basic GUI.
 */
public class GuiController {

    private final GuiView view;
    private final AppDatabase db;
    private OrdersInProgressController ordersInProgress;
    private OrdersPlacedController ordersPlaced;

    public GuiController(GuiView view) {
        this.view = view;

        db = AppDatabase.getAppDatabase();

        new TaskBarController(view.getPanelTop());

        new Thread(this::initView).start();
    }

    private void initView() {
        db.downloadOrders();
        ordersInProgress = new OrdersInProgressController(view.getPanelRight());
        ordersPlaced = new OrdersPlacedController(view.getPanelLeft(), ordersInProgress);
        db.loginEmployeesWithOrders();


        Timer t = new Timer(20_000, e -> {
            db.downloadOrders();
            ordersInProgress.reloadOrders();
            ordersPlaced.reloadOrders();
        });
        t.start();
    }

}


