package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersPlacedView;

import java.util.List;
import java.util.Vector;

public class OrdersPlacedController {

    private final OrdersPlacedView view;
    private final AppDatabase db;
    private final Vector<ItemView> itemViews = new Vector<>();

    public OrdersPlacedController(OrdersPlacedView view) {
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();

    }

    private void addOrders() {
        List<Order> ordersPlaced = db.getOrdersPlaced();
        for (Order order: ordersPlaced) {
            ItemView itemView = new ItemView("Assign", "Details");
            order.setDish(db.getDishById(order.getDish().getId()));
            itemView.setOrder(order);
            new OrderPlacedItemController(order, itemView, this);
            itemViews.addElement(itemView); //add views to vector
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }


    private void renewPanel() {
        view.getScrollablePanel().revalidate();
        view.getScrollablePanel().repaint();
        view.getPanel().revalidate();
        view.getPanel().repaint();
    }

    public void removeItemView(ItemView itemView) {
        view.getScrollablePanel().remove(itemView.getPanel());
        itemView.setToAdd(true);
        renewPanel();
    }


    private void initView() {
        new Thread(this::addOrders).start();
    }

    public OrdersPlacedView getView() {
        return view;
    }

    public AppDatabase getDb() {
        return db;
    }

    public Vector<ItemView> getItemViews() {
        return itemViews;
    }
}
