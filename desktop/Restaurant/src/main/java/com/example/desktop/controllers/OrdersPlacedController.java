package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Dish;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersPlacedView;

import java.util.List;
import java.util.Vector;

public class OrdersPlacedController {

    private OrdersPlacedView view;
    private AppDatabase db;
    private Vector<ItemView> itemViews = new Vector<>();

    public OrdersPlacedController(OrdersPlacedView view) {
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();

    }

    private void addOrders() {
        List<Order> ordersPlaced = db.getOrdersPlaced();
        for (Order order: ordersPlaced) {
            ItemView itemView = new ItemView("Assign", "Details");
            order.setDish(db.getDishFromOrder(order));
            new OrderPlacedItemController(order, itemView);
            itemViews.addElement(itemView); //add views to vector
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }


    private void initView() {
        new Thread(this::addOrders).start();
    }
}
