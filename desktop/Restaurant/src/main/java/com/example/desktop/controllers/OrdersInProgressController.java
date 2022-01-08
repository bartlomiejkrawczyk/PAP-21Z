package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersInProgressView;

import java.util.List;

public class OrdersInProgressController {

    private OrdersInProgressView view;

    private AppDatabase db;

    public OrdersInProgressController(OrdersInProgressView view){
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void addOrders() {
        List<Order> orders = db.getOrdersInProgress();
        for (Order order: orders) {
            ItemView itemView = new ItemView("Assign", "Details");
            new OrderPlacedItemController(order, itemView);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }

    private void initView(){
        new Thread(this::addOrders).start();
    }
}
