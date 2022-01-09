package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.DetailsView;
import com.example.desktop.ui.ItemView;

import java.awt.event.ActionListener;

public class OrderPlacedItemController {

    private final Order orderPlaced;
    private final ItemView view;
    private final AppDatabase db;

    public OrderPlacedItemController(Order orderPlaced, ItemView view) {
        this.orderPlaced = orderPlaced;
        this.view = view;

        db = AppDatabase.getAppDatabase();

        updateView();
        updateActionListener();
    }

    public void updateView() {
        this.view.getLabel().setText(orderPlaced.getDish().getName());
    }

    public void updateActionListener() {
        view.getButton1().addActionListener(e -> assignToCook());
        view.getButton2().addActionListener(e -> showDetails());
    }

    public void assignToCook() {
        CooksView cooksView = new CooksView();
        new AssignmentCookController(cooksView, orderPlaced);
        boolean isAssigned;
        view.setToRemove(true);
    }

    public void showDetails() {
        DetailsView detailsView = new DetailsView();
        new DetailsController(orderPlaced, detailsView);
    }
}

