package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersInProgressView;

import java.awt.*;
import java.util.List;

public class OrdersInProgressController {
    /**
     * Class responsible for controlling whole panel in which are placed
     * view of orders in progress.
     */

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
        Long employeeId = -1L;
        for (Order order : orders) {
            if (!employeeId.equals(order.getEmployee().getId())) {
                ItemView employeeView = new ItemView();
                employeeView.getLabel().setText(order.getEmployee().toString());
                employeeView.getPanel().setBackground(Color.lightGray);
                view.getScrollablePanel().add(employeeView.getPanel());
                employeeId = order.getEmployee().getId();
            }
            ItemView itemView = new ItemView("Done!", "Details");
            order.setDish((db.getDishById(order.getDish().getId())));
            new OrderInProgressItemController(order, itemView, this);
            itemView.setOrder(order);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }

    public void reloadOrders() {
        /**
         * Reload orders by: first, removing them, second: adding them again
         * and reloading whole panel.
         */
        view.getScrollablePanel().removeAll();
        addOrders();
        renewPanel();
    }

    public void removeItem(ItemView itemView) {
        /**
         * Removes particular given itemView from ordersInProgress
         * and reloads panel.
         */
        db.getOrdersInProgress().remove(itemView.getOrder());
        reloadOrders();
    }

    public void addItemView(ItemView itemView) {
        /**
         * Adds given itemView to ordersInProgress
         * and reloads panel.
         */
        db.addOrderInProgress(itemView.getOrder());
        reloadOrders();
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
