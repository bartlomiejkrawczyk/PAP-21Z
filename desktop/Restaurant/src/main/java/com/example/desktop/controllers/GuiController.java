package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.ui.GuiView;
import com.example.desktop.ui.OrdersInProgressView;
import com.example.desktop.ui.OrdersPlacedView;

import javax.swing.*;

public class GuiController {

    GuiView view;
    AppDatabase db;
    TaskBarController taskBar;
    OrdersInProgressController ordersInProgress;
    OrdersPlacedController ordersPlaced;

    public GuiController(GuiView view){
        this.view = view;
        taskBar = new TaskBarController(view.getPanelTop());
        ordersInProgress = new OrdersInProgressController(view.getPanelRight());
        ordersPlaced = new OrdersPlacedController(view.getPanelLeft());
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void initView(){
        new Thread(this::updateView).start();
    }

    private void updateView(){
        db.downloadOrders();
        Timer t = new Timer(20_000, e -> db.downloadOrders());
        t.start();

    }

    public static void main(String[] args){
        GuiView view = new GuiView();
        new GuiController(view);
    }
}


