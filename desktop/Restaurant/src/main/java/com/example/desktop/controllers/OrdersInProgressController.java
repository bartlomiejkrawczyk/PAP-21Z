package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersInProgressView;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class OrdersInProgressController {

    private OrdersInProgressView view;
    private AppDatabase db;
    private Vector<ItemView> itemViews = new Vector<>();
    private Vector<ItemView> itemViewsToAdd = new Vector<>();

    public OrdersInProgressController(OrdersInProgressView view){
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void updateView(){
        Timer t1 = new Timer(500, e -> removeNeedlessItems());
        Timer t2 = new Timer(500, e -> addNewItemViews());
        Timer t3  = new Timer(500, e -> renewPanel());
        t1.start();
        t2.start();
        t3.start();
    }

    private void renewPanel(){
        view.getScrollablePanel().revalidate();
        view.getScrollablePanel().repaint();
        view.getPanel().revalidate();
        view.getPanel().repaint();

    }

    private void addOrders() {
        List<Order> orders = db.getOrdersInProgress();
        for (Order order: orders) {
            ItemView itemView = new ItemView("Done!", "Details");
            order.setDish((db.getDishFromOrder(order)));
            new OrderInProgressItemController(order, itemView);
            itemViews.addElement(itemView); //add views to vector
            itemView.setOrder(order);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }

    private void removeNeedlessItems() {
        Vector<ItemView> toRemove = new Vector<>();
        for (ItemView itemView : itemViews) {
            if (itemView.isToRemove()) {
                view.getScrollablePanel().remove(itemView.getPanel());
                toRemove.addElement(itemView);
            }
        }
        ;
    }

    private void addNewItemViews(){
        for (ItemView itemView: itemViewsToAdd){
            ItemView newItemView = new ItemView("Done!", "Details");
            new OrderInProgressItemController(itemView.getOrder(), newItemView);
            newItemView.setToAdd(false);
            newItemView.setToRemove(false);
            itemViews.addElement(newItemView);
            view.getScrollablePanel().add(newItemView.getPanel());
        }
        itemViewsToAdd.clear();
    }

    private void initView(){
        new Thread(this::addOrders).start();
        new Thread(this::updateView).start();
    }

    public OrdersInProgressView getView() {
        return view;
    }

    public AppDatabase getDb() {
        return db;
    }

    public Vector<ItemView> getItemViews() {
        return itemViews;
    }

    public Vector<ItemView> getItemViewsToAdd() {
        return itemViewsToAdd;
    }
}
