package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;

public class OrderPlacedItemController {

    private final Order orderPlaced;
    private final ItemView view;
    private final AppDatabase db;

    public OrderPlacedItemController(Order orderPlaced, ItemView view) {
        this.orderPlaced = orderPlaced;
        this.view = view;

        db = AppDatabase.getAppDatabase();
    }

    //action listener
    //zrobienie kodu do przycisku assign
    //zrobienie kodu do przycisku details
}

