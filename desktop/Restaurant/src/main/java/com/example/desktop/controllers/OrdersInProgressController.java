package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersInProgressView;

import java.util.List;

public class OrdersInProgressController {

    private final OrdersInProgressView view;
    private final AppDatabase db;
    public OrdersInProgressController(OrdersInProgressView view) {
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void renewPanel(){
        view.getScrollablePanel().revalidate();
        view.getScrollablePanel().repaint();
        view.getPanel().revalidate();
        view.getPanel().repaint();

    }

    private void addOrders() {
        List<Order> orders = db.getOrdersInProgress();
        for (Order order : orders) {
            ItemView itemView = new ItemView("Done!", "Details");
            order.setDish((db.getDishById(order.getDish().getId())));
            new OrderInProgressItemController(order, itemView, this);
            itemView.setOrder(order);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }

    public void removeItem(ItemView itemView) {
        view.getScrollablePanel().remove(itemView.getPanel());
        renewPanel();
    }

    public void addItemView(ItemView itemView) {
        ItemView newItemView = new ItemView("Done!", "Details");
        new OrderInProgressItemController(itemView.getOrder(), newItemView, this);
        newItemView.setToAdd(false);
        newItemView.setToRemove(false);
        view.getScrollablePanel().add(newItemView.getPanel());
        renewPanel();
    }

    private void initView() {
        new Thread(this::addOrders).start();
    }

    public OrdersInProgressView getView() {
        return view;
    }

    public AppDatabase getDb() {
        return db;
    }

}
