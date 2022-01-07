package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
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
        view.getLabel().setText(orderPlaced.getDish().getName());
    }

    public void updateActionListener() {
        view.getButton1().addActionListener(e -> assignToCook());
        view.getButton2().addActionListener(e -> showDetails());
    }

    public void assignToCook() {
        // co będzie się działo po wciśnięciu przycisku assign
    }

    public void showDetails() {
        // co będzie się działo po wciśnięciu przycisku details
    }
}

