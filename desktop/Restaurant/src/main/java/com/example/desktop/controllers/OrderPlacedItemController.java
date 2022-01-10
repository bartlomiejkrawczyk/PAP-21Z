package com.example.desktop.controllers;

import com.example.desktop.entities.Order;
import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.DetailsView;
import com.example.desktop.ui.ItemView;

public class OrderPlacedItemController {

    private final Order orderPlaced;
    private final ItemView view;
    private final OrdersPlacedController parentController;

    public OrderPlacedItemController(Order orderPlaced, ItemView view, OrdersPlacedController parentController) {
        this.orderPlaced = orderPlaced;
        this.view = view;
        this.parentController = parentController;

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
        new AssignmentCookController(cooksView, orderPlaced, () -> parentController.removeItemView(view));
    }

    public void showDetails() {
        DetailsView detailsView = new DetailsView();
        new DetailsController(orderPlaced, detailsView);
    }
}


