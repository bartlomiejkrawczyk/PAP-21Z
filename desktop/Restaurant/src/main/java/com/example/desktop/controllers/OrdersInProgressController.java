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

    public OrdersInProgressController(OrdersInProgressView view){
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void updateView(){
        Timer t1 = new Timer(4000, e -> removeNeedlessItems());
        Timer t2  = new Timer(5000, e -> renewPanel());
        t1.start();
        t2.start();
    }

    private void renewPanel(){
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
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }

    private void removeNeedlessItems(){
        Vector<ItemView> toRemove = new Vector<>();
        for (ItemView itemView : itemViews){
            if (itemView.isToRemove()){
                view.getScrollablePanel().remove(itemView.getPanel());
                toRemove.addElement(itemView);
            }
        }
        for (ItemView itemView: toRemove){
            itemViews.removeElement(itemView);
        }
    }

    private void initView(){
        new Thread(this::addOrders).start();
        new Thread(this::updateView).start();
    }
}
