package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.DetailsView;
import com.example.desktop.ui.ItemView;

public class OrderInProgressItemController {
    /**
     * Class responsible for controlling view of particular order which
     * is in progress.
     */

    private final Order orderInProgress;
    private final ItemView view;
    private final AppDatabase db;

    private final OrdersInProgressController parentController;

    public OrderInProgressItemController(Order order, ItemView view, OrdersInProgressController parentController) {
        this.orderInProgress = order;
        this.view = view;
        this.parentController = parentController;

        db = AppDatabase.getAppDatabase();

        updateView();
        updateActionListener();
    }

    private void updateView() {
        String label = orderInProgress.getDish().getName();
        this.view.getLabel().setText(label);
    }

    private void updateActionListener(){
        view.getButton1().addActionListener(e -> orderDone());
        view.getButton2().addActionListener(e -> showDetails());
    }

    private void orderDone(){
        db.advanceOrderStatus(orderInProgress);
        parentController.removeItem(view);
    }

    private void showDetails(){
        DetailsView view = new DetailsView();
        new DetailsController(orderInProgress, view);
    }
}
