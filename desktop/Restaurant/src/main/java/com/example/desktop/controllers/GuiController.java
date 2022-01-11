package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.ui.GuiView;

import javax.swing.*;

public class GuiController {

    GuiView view;
    AppDatabase db;
    TaskBarController taskBar;
    OrdersInProgressController ordersInProgress;
    OrdersPlacedController ordersPlaced;

    public GuiController(GuiView view){
        this.view = view;

        db = AppDatabase.getAppDatabase();
        db.downloadOrders();

        taskBar = new TaskBarController(view.getPanelTop());
        ordersInProgress = new OrdersInProgressController(view.getPanelRight());
        ordersPlaced = new OrdersPlacedController(view.getPanelLeft(), ordersInProgress);


        initView();
    }

    private void initView(){
        new Thread(this::updateView).start();
    }

    private void updateView() {
        db.downloadOrders();
        db.loginEmployeesWithOrders();

        Timer t = new Timer(20_000, e -> {
            db.downloadOrders();
            ordersInProgress.reloadOrders();
            ordersPlaced.reloadOrders();
        });
        t.start();
    }

    public static void main(String[] args){
        GuiView view = new GuiView();
        new GuiController(view);
    }
}


