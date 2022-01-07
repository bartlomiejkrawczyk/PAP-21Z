package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Dish;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.OrdersPlacedView;

import java.util.List;

public class OrdersPlacedController {

    private OrdersPlacedView view;

    private AppDatabase db;

    public OrdersPlacedController(OrdersPlacedView view) {
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();

    }

    private void initView() {
        new Thread(this::addOrders).start();
    }

    private void addOrders() {
        List<Dish> orders = db.;
        for (Dish dish)

    }
}
