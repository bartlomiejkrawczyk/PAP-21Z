package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.DetailsView;
import com.example.desktop.ui.ItemView;

public class OrderInProgressItemController {

    private Order orderInProgress;
    private ItemView view;
    private AppDatabase db;

    public OrderInProgressItemController(Order order, ItemView view){
        this.orderInProgress = order;
        this.view = view;

        db = AppDatabase.getAppDatabase();

        updateView();
        updateActionListener();
    }

    private void updateView() {
        this.view.getLabel().setText(orderInProgress.getDish().getName());
    }

    private void updateActionListener(){
        view.getButton1().addActionListener(e -> orderDone());
        view.getButton2().addActionListener(e -> showDetails());
    }

    private void orderDone(){
        db.advanceOrderStatus(orderInProgress);
    }

    private void showDetails(){
        DetailsView view = new DetailsView();
        new DetailsController(orderInProgress, view);
    }
}
