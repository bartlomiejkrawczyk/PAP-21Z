package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.ui.GuiView;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersInProgressView;
import com.example.desktop.ui.OrdersPlacedView;

import javax.swing.*;
import java.util.Vector;

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
        ordersPlaced = new OrdersPlacedController(view.getPanelLeft());


        initView();
    }

    private void initView(){
        new Thread(this::updateView).start();
    }

    private void updateView(){
        db.downloadOrders();
        Timer t1 = new Timer(10_000, e -> db.downloadOrders());
        Timer t2 = new Timer(5000, e -> changeSide());
        t1.start();
        t2.start();

    }

    private void changeSide(){
        Vector<ItemView> itemViews = new Vector<>();
        for (ItemView item: ordersPlaced.getItemViews()){
            if (item.isToAdd()){
                itemViews.addElement(item);
            }
        }

        for (ItemView item: itemViews){
            ordersPlaced.getItemViews().removeElement(item);
            ordersInProgress.getItemViewsToAdd().addElement(item);
        }
    }

    public static void main(String[] args){
        GuiView view = new GuiView();
        new GuiController(view);
    }
}


